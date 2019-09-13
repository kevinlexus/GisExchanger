package com.ric.signature.sign.xades;

public class Consts {
    private Consts() {
    }

    private static boolean isGost = true;

    /**
     * Алгоритм электронной подписи
     */
    public static final String SIGNATURE_ALGORITHM = isGost ? "urn:ietf:params:xml:ns:cpxmlsec:algorithms:gostr34102012-gostr34112012-256" : "http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411";
    /**
     * Алгоритм каноникализации для подписи
     */
    public static final String CANONICALIZATION_ALGORITHM_FOR_SIGNATURE = isGost ? "http://www.w3.org/TR/2001/REC-xml-c14n-20010315" : "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    /**
     * Алгоритм каноникализации для штампа времени
     */
    public static final String CANONICALIZATION_ALGORITHM_FOR_TIMESTAMP_PROPERTIES = isGost ? "http://www.w3.org/TR/2001/REC-xml-c14n-20010315" : "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    /**
     * Алгоритм расчета хешей. Используется в XML-документе.
     */
    public static final String DIGEST_ALGORITHM_URI = isGost ? "urn:ietf:params:xml:ns:cpxmlsec:algorithms:gostr34112012-256" : "http://www.w3.org/2001/04/xmldsig-more#gostr3411";
    /**
     * Алгоритм расчета хешей. Используется для создания экземпляра алгоритма.
     */
    public static final String DIGEST_ALGORITHM_NAME = isGost ? "GOST3411_2012_256" : "GOST3411";

    /**
     * Ссылка на блок {@code <xades:SignedSignatureProperties>}
     */
    //public static final String SIGNED_PROPS_TYPE_URI = "http://uri.etsi.org/01903#SignedProperties";

}