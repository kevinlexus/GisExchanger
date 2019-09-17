package com.ric.signature.sign.commands;

import com.ric.signature.sign.exceptions.ElementNotFoundException;
import com.ric.signature.sign.xades.Consts;
import com.ric.signature.sign.xades.production.CustomizableXadesBesSigningProfileFactory;
import com.ric.signature.sign.xades.providers.CustomizableAlgorithmProvider;
import com.ric.signature.sign.xades.providers.CustomizableMessageDigestEngineProvider;
import com.ric.signature.sign.xml.IdResolver;
import com.ric.signature.sign.xml.XMLParser;
import com.ric.signature.sign.xml.XMLPrinter;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.jcajce.JcaX500NameUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.CryptoPro.JCP.KeyStore.JCPPrivateKeyEntry;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.algorithms.ExclusiveCanonicalXMLWithoutComments;
import xades4j.production.*;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.providers.impl.DirectKeyingDataProvider;

import javax.net.ssl.KeyManagerFactory;
import java.io.InputStream;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Выполняет подписание XML-документа.
 */
public class SignCommandGOST2012 implements SignCommands {

    private XadesSigner signer;

    /**
     * Конструктор
     *
     * @param signPass  - пароль на хранилище
     * @param signPath  - хранилище ("FAT12_A", "REGISTRY" и т.п.)
     * @param signEntry - вхождение
     */
    public SignCommandGOST2012(String signPass, String signPath, String signEntry)
            throws Exception {
        ru.CryptoPro.JCPxml.xmldsig.JCPXMLDSigInit.init();
        System.setProperty("org.apache.xml.security.resource.config", "resource/jcp.xml"); // добавил

        Provider provider = new ru.CryptoPro.JCSP.JCSP();
        Security.addProvider(provider);

        // загружаем хранилище закрытых ключей
        KeyStore keyStore = KeyStore.getInstance(signPath, "JCSP");
        KeyManagerFactory kf = KeyManagerFactory.getInstance("GostX509");

        final char[] KEY_PASSWORD_KEY = signPass.toCharArray();

        InputStream stream = null;
        keyStore.load(stream, KEY_PASSWORD_KEY);
        kf.init(keyStore, KEY_PASSWORD_KEY);

        // выводим информацию о хранилище
        System.out.println("Keystore type: " + keyStore.getType());
        System.out.println("Keystore provider: " + provider.getName());
        System.out.println();

        // выводим список ключей/сертификатов
        System.out.println("--------------------------------");
        System.out.println("список ключей/сертификатов:");
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();

            String entryType = "?";
            String entryInfo = null;
            if (keyStore.entryInstanceOf(alias, KeyStore.SecretKeyEntry.class)) { // симметричный ключ шифрования
                entryType = "SecretKeyEntry";
            } else if (keyStore.entryInstanceOf(alias, KeyStore.PrivateKeyEntry.class)) { // закрытый ключ
                entryType = "PrivateKeyEntry";
            } else if (keyStore.entryInstanceOf(alias, KeyStore.TrustedCertificateEntry.class)) { // сертификат
                entryType = "TrustedCertificateEntry";
                Certificate certificate = keyStore.getCertificate(alias);
                // не-X.509 сертификаты игнорируем
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509 = (X509Certificate) certificate;
                    // берем поле Subject из сертификата
                    X500Name subject = JcaX500NameUtil.getSubject(RFC4519Style.INSTANCE, x509);
                    entryInfo = subject.toString();
                }
            }

            System.out.println(alias + ", " + entryType);
            if (entryInfo != null) {
                System.out.println(entryInfo);
            }
        }
        System.out.println("--------------------------------");

        // загружаем закрытый ключ
        try {
            JCPPrivateKeyEntry keyEntry =
                    (JCPPrivateKeyEntry) keyStore.getEntry(signEntry, new KeyStore.PasswordProtection(KEY_PASSWORD_KEY));
            if (keyEntry == null) {
                throw new KeyException("Key not found: " + signPath +" - "+ signEntry);
            }
            // создаем провайдер для доступа к закрытому ключу
            KeyingDataProvider kp = new DirectKeyingDataProvider((X509Certificate) keyEntry.getCertificate(), keyEntry.getPrivateKey());

            // создаем провайдер, описывающий используемые алгоритмы
            CustomizableAlgorithmProvider algorithmsProvider = new CustomizableAlgorithmProvider();
            algorithmsProvider.setSignatureAlgorithm(Consts.SIGNATURE_ALGORITHM);
            algorithmsProvider.setCanonicalizationAlgorithmForSignature(Consts.CANONICALIZATION_ALGORITHM_FOR_SIGNATURE);
            algorithmsProvider.setCanonicalizationAlgorithmForTimeStampProperties(Consts.CANONICALIZATION_ALGORITHM_FOR_TIMESTAMP_PROPERTIES);
            algorithmsProvider.setDigestAlgorithmForDataObjsReferences(Consts.DIGEST_ALGORITHM_URI);
            algorithmsProvider.setDigestAlgorithmForReferenceProperties(Consts.DIGEST_ALGORITHM_URI);
            algorithmsProvider.setDigestAlgorithmForTimeStampProperties(Consts.DIGEST_ALGORITHM_URI);

            // создаем провайдер, ответственный за расчет хешей
            MessageDigestEngineProvider messageDigestEngineProvider =
                    new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

            // настраиваем профиль подписания
            XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                    .withKeyingProvider(kp)
                    .withAlgorithmsProvider(algorithmsProvider)
                    .withMessageDigestEngineProvider(messageDigestEngineProvider)
                    .create();

            // создаем объект, ответственный за создание подписи
            signer = profile.newSigner();
        } catch (Exception e) {
            System.out.println("ОШИБКА! Возникла ошибка при загрузке закрытого ключа");
            throw e;
        }
    }

    @Override
    public String signElem(String doc, String signedElementId, String containerElementId) throws Exception {
        // загружаем проверяемый XML-документ
        Document document = XMLParser.parseXml(doc);

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());

        // ищем подписываемый элемент
        Element signedElement = document.getElementById(signedElementId);

        Element signatureContainer = document.getElementById(containerElementId);
        if (signatureContainer == null) {
            throw new ElementNotFoundException("Container element not found: " + containerElementId);
        }

        // настраиваем подписываемые данные
        DataObjectDesc obj = new DataObjectReference('#' + signedElementId);
        obj.withTransform(new EnvelopedSignatureTransform());

        // если подпись помещается в подписываемый элемент, применяем трансформацию enveloped signature transform
        if (containerElementId.equals(signedElementId)) {
            // если этого не сделать, подпись нельзя будет проверить
            obj.withTransform(new EnvelopedSignatureTransform());
        }

        // применяем трансформацию Exclusive XML Canonicalization 1.0 without comments (комментарии исключаются из подписываемых данных)
        obj.withTransform(new ExclusiveCanonicalXMLWithoutComments());

        // создаем подпись
        SignedDataObjects dataObjs = new SignedDataObjects(obj);
        signer.sign(dataObjs, signatureContainer, SignatureAppendingStrategies.AsFirstChild);

        return XMLPrinter.toString(document);
    }
}