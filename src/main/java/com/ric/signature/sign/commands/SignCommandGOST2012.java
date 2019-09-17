package com.ric.signature.sign.commands;

import com.ric.signature.sign.exceptions.ElementNotFoundException;
import com.ric.signature.sign.xades.Consts;
import com.ric.signature.sign.xades.production.CustomizableXadesBesSigningProfileFactory;
import com.ric.signature.sign.xades.providers.CustomizableAlgorithmProvider;
import com.ric.signature.sign.xades.providers.CustomizableMessageDigestEngineProvider;
import com.ric.signature.sign.xml.IdResolver;
import com.ric.signature.sign.xml.XMLParser;
import com.ric.signature.sign.xml.XMLPrinter;
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
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;

/**
 * Выполняет подписание XML-документа.
 */
public class SignCommandGOST2012 implements SignCommands{

	private Provider provider;
	private XadesSigner signer;

	public SignCommandGOST2012(String signPass, String signPath)
            throws Exception {
        ru.CryptoPro.JCPxml.xmldsig.JCPXMLDSigInit.init();
        System.setProperty("org.apache.xml.security.resource.config", "resource/jcp.xml"); // добавил

        provider = new ru.CryptoPro.JCSP.JCSP();
        Security.addProvider(provider);

        // загружаем хранилище закрытых ключей
        KeyStore ks = KeyStore.getInstance("REGISTRY", "JCSP");
        KeyManagerFactory kf = KeyManagerFactory.getInstance("GostX509");

        //final char[] KEY_PASSWORD_KEY = "12345678".toCharArray();
        final char[] KEY_PASSWORD_KEY = signPass.toCharArray();

        InputStream stream = null;
        ks.load(stream, KEY_PASSWORD_KEY);
        kf.init(ks, KEY_PASSWORD_KEY);

//        JCPPrivateKeyEntry keyEntry =
//                (JCPPrivateKeyEntry) ks.getEntry("Shevchukg2012_CP7", new KeyStore.PasswordProtection(KEY_PASSWORD_KEY));
        JCPPrivateKeyEntry keyEntry =
                (JCPPrivateKeyEntry) ks.getEntry(signPath, new KeyStore.PasswordProtection(KEY_PASSWORD_KEY));

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
        MessageDigestEngineProvider messageDigestEngineProvider = new CustomizableMessageDigestEngineProvider(Consts.DIGEST_ALGORITHM_NAME,  provider);

        // настраиваем профиль подписания
        XadesSigningProfile profile = new CustomizableXadesBesSigningProfileFactory()
                .withKeyingProvider(kp)
                .withAlgorithmsProvider(algorithmsProvider)
                .withMessageDigestEngineProvider(messageDigestEngineProvider)
                .create();

        // создаем объект, ответственный за создание подписи
        System.out.println("************** Finishing init keys...");
        signer =  profile.newSigner();
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

        String signedXml = XMLPrinter.toString(document);
        //System.out.println(signedXml);
        return signedXml;
    }
}