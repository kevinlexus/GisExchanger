package com.ric.signature.sign.commands;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.jcajce.JcaX500NameUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import groovy.util.logging.Log;
import com.ric.signature.sign.args.SignParameters;
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
 * Выполняет подписание XML-документа.
 */
public class SignCommand implements Command {

	private SignParameters parameters;
    private XadesSigner signer;

    //конструктор
    public SignCommand(SignParameters parameters) {
        //System.out.println("############ SIGNCOMMAND CONSTRUCTOR START!");
        org.apache.xml.security.Init.init();
        this.parameters = parameters;
        //System.out.println("############ SIGNCOMMAND CONSTRUCTOR END!");
    }

    //конструктор
    public SignCommand(String signPass, String signPath) throws Exception {
        //System.out.println("############ SIGN COMMAND START!");
        // инициализируем Apache Santuario

        org.apache.xml.security.Init.init();
        //System.out.println("############ SIGN COMMAND INIT!");


        // загружаем криптопровайдер
    	Provider provider = ProviderFactory.createProvider("com.digt.trusted.jce.provider.DIGTProvider", null);
        Security.addProvider(provider);

        // загружаем хранилище закрытых ключей
        char[] storePassword = null;
        char[] keyPassword = signPass.toCharArray();
        //char[] keyPassword = null;
        KeyStore keyStore = KeyStore.getInstance("CryptoProCSPKeyStore", provider);
        KeyStoreUtils.loadKeyStoreByName(keyStore, "CurrentUser/My", storePassword);


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
        //String key = "FAT12\\6CFAFBEC_CRT\\de263rIl.000\\946E"; // - новый
        //String key = "FAT12\\6CFAFBEC_CRT\\le-d483a.000\\9EDE";  - старый
        //String key = "REGISTRY\\\\de263_Iliasov_till_2018chk3";
        //String key = "FAT12\\6CFAFBEC_CRT\\le-d483a.000\\9EDE";
        //String key = "FAT12\\75EEB634\\INN00420.000\\68D6"; // - новый
        //String key = "FAT12\\6CFAFBEC_CRT\\le-d483a.000\\9EDE"; // - новый
        //String key = "REGISTRY\\\\de263_Iliasov_till_2018reg";

        KeyStore.PrivateKeyEntry keyEntry = KeyLoader.loadPrivateKey(keyStore, signPath, keyPassword);
        if (keyEntry == null) {
            throw new KeyException("Key not found: " + signPath);
        }

        //System.out.println("keystore="+keyStore+" - "+parameters.getStoreName());

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
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

        // настраиваем профиль подписания
        XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                .withKeyingProvider(kp)
                .withAlgorithmsProvider(algorithmsProvider)
                .withMessageDigestEngineProvider(messageDigestEngineProvider)
                .create();

        // создаем объект, ответственный за создание подписи
        signer = profile.newSigner();
        //System.out.println("############ SIGN COMMAND END!");
    }

    public SignCommand(int i) {
		// TODO Auto-generated constructor stub
	}

	public String signElem(String doc, String signedElementId, String containerElementId) throws Exception {
        //System.out.println("############ SIGN ELEM START!");
        //System.out.println("############ SIGN ELEM1:"+doc);
        //System.out.println("############ SIGN ELEM2:"+signedElementId);
        //System.out.println("############ SIGN ELEM3:"+containerElementId);
        // загружаем проверяемый XML-документ
        //Document document = XMLParser.parseXml(parameters.getInputFile());
        Document document = XMLParser.parseXml(doc);
        //System.out.println("SC 2.0");

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());
        //System.out.println("SC 2.1");

        // ищем подписываемый элемент
        Element signedElement = document.getElementById(signedElementId);
        if (signedElement == null) {
            throw new ElementNotFoundException("Element to be signed not found: " + signedElementId);
        }
        //System.out.println("SC 2.2");

        // ищем элемент, в который нужно поместить подпись; если не указан, помещаем подпись в подписываемый элемент
        Element signatureContainer = document.getElementById(containerElementId);
        if (signatureContainer == null) {
            throw new ElementNotFoundException("Container element not found: " + containerElementId);
        }
        //System.out.println("SC 2.3");

        // настраиваем подписываемые данные
        DataObjectDesc obj = new DataObjectReference('#' + signedElementId);
        //System.out.println("SC 2.4");

        if (containerElementId.equals(signedElementId)) {
            // если подпись помещается в подписываемый элемент, применяем трансформацию enveloped signature transform
            // если этого не сделать, подпись нельзя будет проверить
            //System.out.println("SC 2.5");
            obj.withTransform(new EnvelopedSignatureTransform());
        }
        //System.out.println("SC 2.6");

        // применяем трансформацию Exclusive XML Canonicalization 1.0 without comments (комментарии исключаются из подписываемых данных)
        obj.withTransform(new ExclusiveCanonicalXMLWithoutComments());
        //System.out.println("SC 2.7");

        // создаем подпись
        SignedDataObjects dataObjs = new SignedDataObjects(obj);
        //System.out.println("SC 2.8");
        signer.sign(dataObjs, signatureContainer, SignatureAppendingStrategies.AsFirstChild);
        //System.out.println("SC 2.9");

        return XMLPrinter.toString(document);
    }

    public void execute() throws Exception {
        //System.out.println("############ EXECUTE!");
        // инициализируем Apache Santuario
        org.apache.xml.security.Init.init();
        //System.out.println("############ INIT!");

        // загружаем криптопровайдер
        String providerName = parameters.getProviderName();
        Provider provider = providerName == null ? null : Security.getProvider(providerName);
        if (provider == null) {
            provider = ProviderFactory.createProvider(parameters.getProviderClass(), parameters.getProviderArg());
            Security.addProvider(provider);
        }

        // загружаем хранилище закрытых ключей
        char[] storePassword = parameters.getStorePassword() == null ? null : StringUtils.defaultString(parameters.getStorePassword()).toCharArray();
        char[] keyPassword = parameters.getKeyPassword() == null ? null : StringUtils.defaultString(parameters.getKeyPassword()).toCharArray();
        KeyStore keyStore = KeyStore.getInstance(parameters.getStoreType(), provider);
        if (parameters.getStoreFile() != null) {
            KeyStoreUtils.loadKeyStoreFromFile(keyStore, parameters.getStoreFile(), storePassword);
        } else if (parameters.getStoreName() != null) {
            KeyStoreUtils.loadKeyStoreByName(keyStore, parameters.getStoreName(), storePassword);
        }

        // загружаем закрытый ключ
        KeyStore.PrivateKeyEntry keyEntry = KeyLoader.loadPrivateKey(keyStore, parameters.getAlias(), keyPassword);
        if (keyEntry == null) {
            throw new KeyException("Key not found: " + parameters.getAlias());
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
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME, provider);

        // настраиваем профиль подписания
        XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                .withKeyingProvider(kp)
                .withAlgorithmsProvider(algorithmsProvider)
                .withMessageDigestEngineProvider(messageDigestEngineProvider)
                .create();

        // создаем объект, ответственный за создание подписи
        XadesSigner signer = profile.newSigner();

        // загружаем проверяемый XML-документ
        Document document = XMLParser.parseXml(parameters.getInputFile());

        // объявляем атрибут Id в качестве идентифицирующего
        IdResolver.resolveIds(document.getDocumentElement());

        // ищем подписываемый элемент
        String signedElementId = parameters.getSignedElementId();
        Element signedElement = document.getElementById(signedElementId);
        if (signedElement == null) {
            throw new ElementNotFoundException("Element to be signed not found: " + signedElementId);
        }

        // ищем элемент, в который нужно поместить подпись; если не указан, помещаем подпись в подписываемый элемент
        String containerElementId = parameters.getContainerElementId() == null ? signedElementId : parameters.getContainerElementId();
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

        if (parameters.getOutputFile() == null) {
            // выводим результат в stdout
            System.out.println(XMLPrinter.toString(document));
        } else {
            // выводим результат в файл
            byte[] xmlBytes = XMLPrinter.toBytes(document);
            FileUtils.writeByteArrayToFile(parameters.getOutputFile(), xmlBytes);
        }
    }

}
