//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.02 at 03:51:49 PM CET 
//


package it.gov.impresainungiorno.schema.suap.ricevuta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RicevutaPraticaSUAP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RicevutaPraticaSUAP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="info-schema">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="versione" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;pattern value="(\d+.)?\d+.\d+(-beta)?"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="data" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="intestazione" type="{http://www.impresainungiorno.gov.it/schema/suap/ricevuta}IntestazioneRicevuta"/>
 *         &lt;element name="allegato" type="{http://www.impresainungiorno.gov.it/schema/base}Stringa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RicevutaPraticaSUAP", propOrder = {
    "infoSchema",
    "intestazione",
    "allegato"
})
@XmlRootElement(name = "ricevuta-pratica-suap")
public class RicevutaPraticaSUAP {

    @XmlElement(name = "info-schema", required = true)
    protected RicevutaPraticaSUAP.InfoSchema infoSchema;
    @XmlElement(required = true)
    protected IntestazioneRicevuta intestazione;
    protected List<String> allegato;

    /**
     * Gets the value of the infoSchema property.
     * 
     * @return
     *     possible object is
     *     {@link RicevutaPraticaSUAP.InfoSchema }
     *     
     */
    public RicevutaPraticaSUAP.InfoSchema getInfoSchema() {
        return infoSchema;
    }

    /**
     * Sets the value of the infoSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link RicevutaPraticaSUAP.InfoSchema }
     *     
     */
    public void setInfoSchema(RicevutaPraticaSUAP.InfoSchema value) {
        this.infoSchema = value;
    }

    /**
     * Gets the value of the intestazione property.
     * 
     * @return
     *     possible object is
     *     {@link IntestazioneRicevuta }
     *     
     */
    public IntestazioneRicevuta getIntestazione() {
        return intestazione;
    }

    /**
     * Sets the value of the intestazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntestazioneRicevuta }
     *     
     */
    public void setIntestazione(IntestazioneRicevuta value) {
        this.intestazione = value;
    }

    /**
     * Gets the value of the allegato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allegato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllegato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAllegato() {
        if (allegato == null) {
            allegato = new ArrayList<String>();
        }
        return this.allegato;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="versione" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;pattern value="(\d+.)?\d+.\d+(-beta)?"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="data" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class InfoSchema {

        @XmlAttribute(required = true)
        protected String versione;
        @XmlAttribute(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar data;

        /**
         * Gets the value of the versione property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersione() {
            return versione;
        }

        /**
         * Sets the value of the versione property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersione(String value) {
            this.versione = value;
        }

        /**
         * Gets the value of the data property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getData() {
            return data;
        }

        /**
         * Sets the value of the data property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setData(XMLGregorianCalendar value) {
            this.data = value;
        }

    }

}