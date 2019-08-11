
package ru.gosuslugi.dom.schema.integration.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Результат экспорта сведений о выполненных работах и услугах
 * 
 * <p>Java class for exportCompletedWorksResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportCompletedWorksResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorksByPeriodExportType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportCompletedWorksResultType")
public class ExportCompletedWorksResultType
    extends CompletedWorksByPeriodExportType
{


}
