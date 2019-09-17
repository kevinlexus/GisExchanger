package com.ric.signature.sign.commands;

public interface SignCommands {

    String signElem(String doc, String signedElementId, String containerElementId) throws Exception;
}
