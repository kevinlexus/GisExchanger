package com.ric.signature.sign.jce;

import java.io.ByteArrayInputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Вспомогательный класс для загрузки ключей.
 */
public class KeyLoader {
    private KeyLoader() {
    }

    /**
     * Загрузить закрытый ключ
     *
     * @param keyStore хранилище ключей
     * @param alias имя ключа
     * @param keyPassword пароль
     * @return загруженный ключ или null
     * @throws GeneralSecurityException
     */
/*
    public static PrivateKey loadPrivateKey(KeyStore keyStore, String alias, char[] keyPassword) throws GeneralSecurityException {
        try {
            //KeyStore.PasswordProtection protection = new KeyStore.PasswordProtection(keyPassword);
            //KeyStore.PrivateKeyEntry key = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias, protection);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, keyPassword);
            return privateKey;
        } catch (GeneralSecurityException e) {
            throw new KeyException("Cannot load key: " + alias, e);
        }
    }
*/
    public static PrivateKey getPrivateKey(KeyStore keyStore, String alias, char[] keyPassword)
            throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        return (PrivateKey) keyStore.getKey(alias, keyPassword);
    }

    public static X509Certificate getX509Certificate(KeyStore keyStore, String alias) throws CertificateException, KeyStoreException {
        X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
        if (certificate == null)
            return null;
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(certificate.getEncoded()));
    }

}
