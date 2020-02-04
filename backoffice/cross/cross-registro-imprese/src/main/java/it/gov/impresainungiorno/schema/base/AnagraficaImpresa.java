
package it.gov.impresainungiorno.schema.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Questo elemento contiene i dati identificativi di un'impresa. Forma-giuridica: contiene come attributo il codice della forma
 *         giuridica, come contenuto il nome esteso. 
 * 
 * <p>Java class for AnagraficaImpresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnagraficaImpresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="forma-giuridica" type="{http://www.impresainungiorno.gov.it/schema/base}FormaGiuridica" minOccurs="0"/>
 *         &lt;element name="ragione-sociale" type="{http://www.impresainungiorno.gov.it/schema/base}Stringa"/>
 *         &lt;element name="codice-fiscale" type="{http://www.impresainungiorno.gov.it/schema/base}CodiceFiscale"/>
 *         &lt;element name="partita-iva" type="{http://www.impresainungiorno.gov.it/schema/base}PartitaIVA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnagraficaImpresa", propOrder = {
    "formaGiuridica",
    "ragioneSociale",
    "codiceFiscale",
    "partitaIva"
})
@XmlSeeAlso({
    DettaglioImpresa.class
})
public class AnagraficaImpresa {

    @XmlElement(name = "forma-giuridica")
    protected FormaGiuridica formaGiuridica;
    @XmlElement(name = "ragione-sociale", required = true)
    protected String ragioneSociale;
    @XmlElement(name = "codice-fiscale", required = true)
    protected String codiceFiscale;
    @XmlElement(name = "partita-iva")
    protected String partitaIva;

    /**
     * Gets the value of the formaGiuridica property.
     * 
     * @return
     *     possible object is
     *     {@link FormaGiuridica }
     *     
     */
    public FormaGiuridica getFormaGiuridica() {
        return formaGiuridica;
    }

    /**
     * Sets the value of the formaGiuridica property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormaGiuridica }
     *     
     */
    public void setFormaGiuridica(FormaGiuridica value) {
        this.formaGiuridica = value;
    }

    /**
     * Gets the value of the ragioneSociale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    /**
     * Sets the value of the ragioneSociale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRagioneSociale(String value) {
        this.ragioneSociale = value;
    }

    /**
     * Gets the value of the codiceFiscale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Sets the value of the codiceFiscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Gets the value of the partitaIva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIva() {
        return partitaIva;
    }

    /**
     * Sets the value of the partitaIva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIva(String value) {
        this.partitaIva = value;
    }

}