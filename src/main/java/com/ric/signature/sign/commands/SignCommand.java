package com.ric.signature.sign.commands;

import com.ric.signature.sign.exceptions.ElementNotFoundException;
import com.ric.signature.sign.jce.KeyLoader;
import com.ric.signature.sign.jce.KeyStoreUtils;
import com.ric.signature.sign.jce.ProviderFactory;
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
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.algorithms.ExclusiveCanonicalXMLWithoutComments;
import xades4j.production.*;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.MessageDigestEngineProvider;
import xades4j.providers.impl.DirectKeyingDataProvider;

import java.security.KeyException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Выполняет подпись XML-документа.
 */
public class SignCommand implements SignCommands{

    private XadesSigner signer;

    //конструктор
    public SignCommand(String signPass, String signPath) throws Exception {
        // инициализируем Apache Santuario
        org.apache.xml.security.Init.init();

        // загружаем криптопровайдер
        Provider provider = ProviderFactory.createProvider("com.digt.trusted.jce.provider.DIGTProvider", null);
        Security.addProvider(provider);

        // загружаем хранилище закрытых ключей
        char[] keyPassword = signPass.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("CryptoProCSPKeyStore", provider);
        KeyStoreUtils.loadKeyStoreByName(keyStore, "CurrentUser/My", null);
        //KeyStoreUtils.loadKeyStoreByName(keyStore, "LocalComputer/My", "12345678".toCharArray());

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
            KeyStore.PrivateKeyEntry keyEntry = KeyLoader.loadPrivateKey(keyStore, signPath, keyPassword);
            if (keyEntry == null) {
                throw new KeyException("Key not found: " + signPath);
            }
            // создаем провайдер для доступа к закрытому ключу
            KeyingDataProvider kp = new DirectKeyingDataProvider((X509Certificate) keyEntry.getCertificate(), keyEntry.getPrivateKey());

            // создаем провайдер, описывающий используемые алгоритмы
            CustomizableAlgorithmProvider algorithmsProvider = new CustomizableAlgorithmProvider();
            algorithmsProvider.setSignatureAlgorithm(Consts.SIGNATURE_ALGORITHM);
            algorithmsProvider.setCanonicalizationAlgorithmForSignature(Consts.CANONICALIZATION_ALGORITHM_FOR_SIGNATURE);
            algorithmsProvider.setCanonicalizationAlgorithmForTimeStampProperties(
                    Consts.CANONICALIZATION_ALGORITHM_FOR_TIMESTAMP_PROPERTIES);
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
        } catch (Exception e){
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
        if (signedElement == null) {
            throw new ElementNotFoundException("Element to be signed not found: " + signedElementId);
        }
        // ищем элемент, в который нужно поместить подпись; если не указан, помещаем подпись в подписываемый элемент
        Element signatureContainer = document.getElementById(containerElementId);
        if (signatureContainer == null) {
            throw new ElementNotFoundException("Container element not found: " + containerElementId);
        }
        // настраиваем подписываемые данные
        DataObjectDesc obj = new DataObjectReference('#' + signedElementId);
        if (containerElementId.equals(signedElementId)) {
            // если подпись помещается в подписываемый элемент, применяем трансформацию enveloped signature transform
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
