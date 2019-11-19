package com.ric.signature.sign.xades;

/**
 * Имена используемых алгоритмов.
 */
public class Consts {
    public Consts(boolean isGost) {
        this.isGost=isGost;
    }

    private boolean isGost;

    public String getSignatureAlgorithm() {
        return isGost ? "urn:ietf:params:xml:ns:cpxmlsec:algorithms:gostr34102012-gostr34112012-256" : "http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411";
    }

    public String getCanonicalizationAlgorithmForSignature() {
        return isGost ? "http://www.w3.org/TR/2001/REC-xml-c14n-20010315" : "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    }

    public String getCanonicalizationAlgorithmForTimestampProperties() {
        return isGost ? "http://www.w3.org/TR/2001/REC-xml-c14n-20010315" : "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    }

    public String getDigestAlgorithmUri() {
        return isGost ? "urn:ietf:params:xml:ns:cpxmlsec:algorithms:gostr34112012-256" : "http://www.w3.org/2001/04/xmldsig-more#gostr3411";
    }

    public String getDigestAlgorithmName() {
        return isGost ? "GOST3411v12256" : "GOST3411";
    }

}
