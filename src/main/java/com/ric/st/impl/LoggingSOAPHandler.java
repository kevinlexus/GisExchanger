package com.ric.st.impl;

import com.ric.web.Soap2GisApplication;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Set;

@Slf4j
public class LoggingSOAPHandler implements SOAPHandler<SOAPMessageContext> {


    /**
     * Is called after constructing the handler and before executing any othe method.
     */
    @PostConstruct
    public void init() {

    }


    public void close(MessageContext arg0) {

    }

    public boolean handleMessage(SOAPMessageContext context) {
        boolean trace = false;
        int signerId;
        trace = context.containsKey("trace");
        String signerIdS = (String) context.get("signerId");
        signerId = Integer.valueOf(signerIdS);

        Boolean outboundProperty = (Boolean)
                context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage soapMsg = context.getMessage();

        if (!outboundProperty) {

            if (trace) {
                log.info("Sended XML:");
                dumpSOAPMessage(soapMsg);
            }

        } else {
            boolean sign;
            sign = context.containsKey("sign");

            try {
                soapMsg.getSOAPPart().getEnvelope();
            } catch (SOAPException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (trace) {
                log.info("Before sign XML:");
                dumpSOAPMessage(soapMsg);
            }

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            try {
                soapMsg.writeTo(bs);
            } catch (SOAPException | IOException e) {
                e.printStackTrace();
            }

            // подпись элемента
            Node nd = null;
            //log.info("SIGN 1.0");
            if (sign) {
                String sgn = null;
                try {
                    //log.info("SIGN 1.1");
                    if (signerId == 1) {
                        log.info("************* Выбран signerId=1");
                        sgn = Soap2GisApplication.sc.signElem(bs.toString(), "foo", "foo");
                    } else {
                        log.info("************* Выбран signerId=2");
                        sgn = Soap2GisApplication.sc2.signElem(bs.toString(), "foo", "foo");
                    }
                    //log.info("SIGN 1.2");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                // Получить элемент подписи
                //log.info("SIGN 1.3");
                DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
                try {
                    //log.info("SIGN 1.4");
                    domFactory.setNamespaceAware(true);

//	            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, Boolean.TRUE);
//	            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", Boolean.TRUE);
//	            dbf.setNamespaceAware(true);

                    //log.info("SIGN 1.5");
                    DocumentBuilder builder = domFactory.newDocumentBuilder();
                    //log.info("SIGN 1.6");
                    InputSource is = new InputSource(new StringReader(sgn));
                    //log.info("SIGN 1.7");
                    Document dDoc = builder.parse(is);


                    //log.info("SIGN 1.8");
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    //log.info("SIGN 1.9");
                    javax.xml.xpath.XPathExpression expr = xpath.compile("//*[local-name()='Signature']");
                    //log.info("SIGN 1.10");
                    Object result = expr.evaluate(dDoc, XPathConstants.NODESET);
                    //log.info("SIGN 1.11");
                    NodeList nodes = (NodeList) result;
                    //log.info("SIGN 1.12");

                    nd = nodes.item(0);
                    //log.info("SIGN 1.13");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //

            if (sign) {
                Node itm = null;
                try {
                    //log.info("SIGN 1.14");
                    SOAPBody body = soapMsg.getSOAPBody();
                    //NodeList blst = body.getElementsByTagNameNS("*", "exportNsiItemRequest");
                    //soapMsg.getSOAPPart().getEnvelope().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/");

                    //log.info("SIGN 1.15");
                    itm = findElem(body, "Id", "foo");
                    //log.info("SIGN 1.16");
                    Node itm2 = itm.getFirstChild();
                    //log.info("SIGN 1.17");

                    Document doc = body.getOwnerDocument();
                    //log.info("SIGN 1.18");
                    doc.adoptNode(nd);
                    //log.info("SIGN 1.19");
                    //doc.importNode(nd, false);
                    itm.insertBefore(nd, itm2);
                    //log.info("SIGN 1.20");
                    // сохранить XML
                    soapMsg.saveChanges();
                    //log.info("SIGN 1.21");
                    //log.info("XML saved!");
                } catch (SOAPException e1) {
                    //log.info("XML DOESN'T saved!");
                    e1.printStackTrace();
                }
                if (trace) {
                    //log.info("Sended XML:");
                    dumpSOAPMessage(soapMsg);
                    //log.info("SIGN 1.22");
                }
            }
        }
        // продолжить выполнение - true
        //log.info("SIGN 1.23");
        return true;
    }

    // найти элемент с идентификатором
    private Node findElem(SOAPBody body, String id, String val) {
        NodeList blst = body.getChildNodes();
        for (int i = 0; i <= blst.getLength(); i++) {
            if (blst.item(i) != null) {
                NamedNodeMap nm = blst.item(i).getAttributes();
                for (int a = 0; a <= nm.getLength(); a++) {
                    if (nm.item(a) != null && nm.item(a).getNodeName().equals(id) && nm.item(a).getNodeValue().equals(val)) {
                        return blst.item(0);
                    }
                }
            }
        }
        return null;
    }

    public Set<QName> getHeaders() {
        return null;
    }

    /**
     * Returns the message encoding (e.g. utf-8)
     *
     * @param msg
     * @return
     * @throws javax.xml.soap.SOAPException
     */
    private String getMessageEncoding(SOAPMessage msg) throws SOAPException {
        String encoding = "utf-8";
        if (msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING) != null) {
            log.info("getMessageEncoding-1");
            encoding = msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING).toString();
        }
        log.info("getMessageEncoding-2");
        return encoding;
    }


    /**
     * Dump SOAP Message to console
     *
     * @param msg
     */
    private void dumpSOAPMessage(SOAPMessage msg) {
        if (msg == null) {
            log.info("SOAP Message is null");
            return;
        } else {
            log.info("");
            log.info("--------------------");
            log.info("DUMP OF SOAP MESSAGE");
            log.info("--------------------");
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                msg.writeTo(baos);
                log.info(baos.toString(getMessageEncoding(msg)));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * Handles SOAP-Errors.
     *
     * @param context
     * @return
     */
    public boolean handleFault(SOAPMessageContext context) {
        log.info("ServerSOAPHandler.handleFault");
        boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) {
            log.info("Direction=outbound (handleFault)");
        } else {
            log.info("Direction=inbound (handleFault)");
        }
        if (!outbound) {
            try {
                SOAPMessage msg = ((SOAPMessageContext) context).getMessage();
                dumpSOAPMessage(msg);
                if (context.getMessage().getSOAPBody().getFault() != null) {
                    String detailName = null;
                    try {
                        detailName = context.getMessage().getSOAPBody().getFault().getDetail().getFirstChild().getLocalName();
                        log.info("detailName=" + detailName);
                    } catch (Exception e) {
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}
