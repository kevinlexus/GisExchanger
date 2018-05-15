package com.ric.signature.sign.commands;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Команда.
 */
public interface Command {
    void execute() throws Exception;
    String signElem(String doc, String signedElementId, String containerElementId) throws Exception;
}
