package com.ric.st.impl;

import com.ric.web.Soap2GisApplication;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPBody;
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


    @Override
    public void close(MessageContext arg0) {

    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean trace;
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
            Node node = null;
            if (sign) {
                String sgn = null;
                try {
                    if (signerId == 1) {
                        log.info("************* Выбран signerId=1");
                        sgn = Soap2GisApplication.sc.signElem(bs.toString(), "foo", "foo");
                    } else {
                        log.info("************* Выбран signerId=2");
                        sgn = Soap2GisApplication.sc2.signElem(bs.toString(), "foo", "foo");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                if (sgn == null) {
                    throw new RuntimeException("Soap2GisApplication.sc.signElem вернул null!");
                }
                // Получить элемент подписи
                DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
                try {
                    domFactory.setNamespaceAware(true);
                    DocumentBuilder builder = domFactory.newDocumentBuilder();
                    InputSource is = new InputSource(new StringReader(sgn));
                    Document dDoc = builder.parse(is);

                    XPath xpath = XPathFactory.newInstance().newXPath();
                    javax.xml.xpath.XPathExpression expr = xpath.compile("//*[local-name()='Signature']");
                    Object result = expr.evaluate(dDoc, XPathConstants.NODESET);
                    NodeList nodes = (NodeList) result;
                    node = nodes.item(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (sign) {
                Node itm;
                try {
                    SOAPBody body = soapMsg.getSOAPBody();
                    itm = findElem(body);
                    if (itm == null) {
                        throw new RuntimeException("findElem вернул null!");
                    }
                    Node itm2 = itm.getFirstChild();
                    Document doc = body.getOwnerDocument();
                    doc.adoptNode(node);
                    itm.insertBefore(node, itm2);
                    soapMsg.saveChanges();
                } catch (SOAPException e1) {
                    e1.printStackTrace();
                }
                if (trace) {
                    dumpSOAPMessage(soapMsg);
                }
            }
        }
        return true;
    }

    /**
     * найти элемент с идентификатором
     *
     * @param body - тело запроса
     * @return - элемент
     */
    private Node findElem(SOAPBody body) {
        String id = "Id";
        String val = "foo";
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

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    /**
     * Вернуть кодировку сообщения
     *
     * @param msg - SOAP сообщение
     * @return - кодировка
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
     * Печать SOAP сообщение
     *
     * @param msg - сообщение
     */
    private void dumpSOAPMessage(SOAPMessage msg) {
        if (msg == null) {
            log.warn("SOAP Message is null");
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
     * Обработчик SOAP ошибок
     *
     * @param context - контекст SOAP сообщения
     */
    @Override
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
                SOAPMessage msg = context.getMessage();
                dumpSOAPMessage(msg);
                if (context.getMessage().getSOAPBody().getFault() != null) {
                    String detailName;
                    try {
                        detailName = context.getMessage().getSOAPBody().getFault().getDetail().getFirstChild().getLocalName();
                        log.info("detailName=" + detailName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}
