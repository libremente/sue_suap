//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.12.27 at 06:54:59 PM CET 
//
package it.wego.people.simpledesk.processdata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="campi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element ref="{}azione"/>
 *                   &lt;element ref="{}campiCollegati"/>
 *                   &lt;element ref="{}campoTitolare"/>
 *                   &lt;element ref="{}campo_collegato"/>
 *                   &lt;element ref="{}campo_dati"/>
 *                   &lt;element ref="{}campo_key"/>
 *                   &lt;element ref="{}campo_xml_mod"/>
 *                   &lt;element ref="{}contatore"/>
 *                   &lt;element ref="{}controllo"/>
 *                   &lt;element ref="{}decimali"/>
 *                   &lt;element ref="{}descrizione"/>
 *                   &lt;element ref="{}edit"/>
 *                   &lt;element ref="{}err_msg"/>
 *                   &lt;element ref="{}flg_precompilazione"/>
 *                   &lt;element ref="{}livello"/>
 *                   &lt;element ref="{}lunghezza"/>
 *                   &lt;element ref="{}marcatore_incrociato"/>
 *                   &lt;element ref="{}molteplicita"/>
 *                   &lt;element ref="{}nome"/>
 *                   &lt;element ref="{}nome_xsd"/>
 *                   &lt;element ref="{}numCampo"/>
 *                   &lt;element ref="{}opzioniCombo"/>
 *                   &lt;element ref="{}pattern"/>
 *                   &lt;element ref="{}posizione"/>
 *                   &lt;element ref="{}precompilazione"/>
 *                   &lt;element ref="{}raggruppamento_check"/>
 *                   &lt;element ref="{}riga"/>
 *                   &lt;element ref="{}tipo"/>
 *                   &lt;element ref="{}tp_controllo"/>
 *                   &lt;element ref="{}val_campo_collegato"/>
 *                   &lt;element ref="{}valore"/>
 *                   &lt;element ref="{}valoreUtente"/>
 *                   &lt;element ref="{}web_serv"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "campi"
})
@XmlRootElement(name = "campi")
public class CampiWrapper {

    protected List<CampiWrapper.Campi> campi;

    /**
     * Gets the value of the campi property.
     *
     * <p> This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the campi property.
     *
     * <p> For example, to add a new item, do as follows:
     * <pre>
     *    getCampi().add(newItem);
     * </pre>
     *
     *
     * <p> Objects of the following type(s) are allowed in the list
     * {@link Campi.Campi }
     *
     *
     */
    public List<CampiWrapper.Campi> getCampi() {
        if (campi == null) {
            campi = new ArrayList<CampiWrapper.Campi>();
        }
        return this.campi;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained
     * within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element ref="{}azione"/>
     *         &lt;element ref="{}campiCollegati"/>
     *         &lt;element ref="{}campoTitolare"/>
     *         &lt;element ref="{}campo_collegato"/>
     *         &lt;element ref="{}campo_dati"/>
     *         &lt;element ref="{}campo_key"/>
     *         &lt;element ref="{}campo_xml_mod"/>
     *         &lt;element ref="{}contatore"/>
     *         &lt;element ref="{}controllo"/>
     *         &lt;element ref="{}decimali"/>
     *         &lt;element ref="{}descrizione"/>
     *         &lt;element ref="{}edit"/>
     *         &lt;element ref="{}err_msg"/>
     *         &lt;element ref="{}flg_precompilazione"/>
     *         &lt;element ref="{}livello"/>
     *         &lt;element ref="{}lunghezza"/>
     *         &lt;element ref="{}marcatore_incrociato"/>
     *         &lt;element ref="{}molteplicita"/>
     *         &lt;element ref="{}nome"/>
     *         &lt;element ref="{}nome_xsd"/>
     *         &lt;element ref="{}numCampo"/>
     *         &lt;element ref="{}opzioniCombo"/>
     *         &lt;element ref="{}pattern"/>
     *         &lt;element ref="{}posizione"/>
     *         &lt;element ref="{}precompilazione"/>
     *         &lt;element ref="{}raggruppamento_check"/>
     *         &lt;element ref="{}riga"/>
     *         &lt;element ref="{}tipo"/>
     *         &lt;element ref="{}tp_controllo"/>
     *         &lt;element ref="{}val_campo_collegato"/>
     *         &lt;element ref="{}valore"/>
     *         &lt;element ref="{}valoreUtente"/>
     *         &lt;element ref="{}web_serv"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "campi", propOrder = {})
    public static class Campi {

        @XmlElement(required = true)
        protected String azione;
        @XmlElement(required = true)
        protected CampiCollegati campiCollegati;
        @XmlElement(required = true)
        protected String campoTitolare;
        @XmlElement(name = "campo_collegato", required = true)
        protected String campoCollegato;
        @XmlElement(name = "campo_dati", required = true)
        protected String campoDati;
        @XmlElement(name = "campo_key", required = true)
        protected String campoKey;
        @XmlElement(name = "campo_xml_mod", required = true)
        protected String campoXmlMod;
        @XmlElement(required = true)
        protected Integer contatore;
        @XmlElement(required = true)
        protected String controllo;
        @XmlElement(required = true)
        protected Integer decimali;
        @XmlElement(required = true)
        protected String descrizione;
        @XmlElement(required = true)
        protected String edit;
        @XmlElement(name = "err_msg", required = true)
        protected String errMsg;
        @XmlElement(name = "flg_precompilazione", required = true)
        protected String flgPrecompilazione;
        @XmlElement(required = true)
        protected Integer livello;
        @XmlElement(required = true)
        protected Integer lunghezza;
        @XmlElement(name = "marcatore_incrociato", required = true)
        protected String marcatoreIncrociato;
        @XmlElement(required = true)
        protected Integer molteplicita;
        @XmlElement(required = true)
        protected String nome;
        @XmlElement(name = "nome_xsd", required = true)
        protected String nomeXsd;
        @XmlElement(required = true)
        protected Integer numCampo;
        @XmlElement(required = true)
        protected OpzioniComboWrapper opzioniCombo;
        @XmlElement(required = true)
        protected String pattern;
        @XmlElement(required = true)
        protected Integer posizione;
        @XmlElement(required = true)
        protected String precompilazione;
        @XmlElement(name = "raggruppamento_check", required = true)
        protected String raggruppamentoCheck;
        @XmlElement(required = true)
        protected Integer riga;
        @XmlElement(required = true)
        protected String tipo;
        @XmlElement(name = "tp_controllo", required = true)
        protected String tpControllo;
        @XmlElement(name = "val_campo_collegato", required = true)
        protected String valCampoCollegato;
        @XmlElement(required = true)
        protected String valore;
        @XmlElement(required = true)
        protected String valoreUtente;
        @XmlElement(name = "web_serv", required = true)
        protected String webServ;

        /**
         * Gets the value of the azione property.
         *
         * @return possible object is {@link Azione }
         *
         */
        public String getAzione() {
            return azione;
        }

        /**
         * Sets the value of the azione property.
         *
         * @param value allowed object is {@link Azione }
         *
         */
        public void setAzione(String value) {
            this.azione = value;
        }

        public String getCampoTitolare() {
            return campoTitolare;
        }

        public void setCampoTitolare(String campoTitolare) {
            this.campoTitolare = campoTitolare;
        }

        /**
         * Gets the value of the campiCollegati property.
         *
         * @return possible object is {@link CampiCollegati }
         *
         */
        public CampiCollegati getCampiCollegati() {
            return campiCollegati;
        }

        /**
         * Sets the value of the campiCollegati property.
         *
         * @param value allowed object is {@link CampiCollegati }
         *
         */
        public void setCampiCollegati(CampiCollegati value) {
            this.campiCollegati = value;
        }

        /**
         * Gets the value of the campoCollegato property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getCampoCollegato() {
            return campoCollegato;
        }

        /**
         * Sets the value of the campoCollegato property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setCampoCollegato(String value) {
            this.campoCollegato = value;
        }

        /**
         * Gets the value of the campoDati property.
         *
         * @return possible object is {@link CampoDati }
         *
         */
        public String getCampoDati() {
            return campoDati;
        }

        /**
         * Sets the value of the campoDati property.
         *
         * @param value allowed object is {@link CampoDati }
         *
         */
        public void setCampoDati(String value) {
            this.campoDati = value;
        }

        /**
         * Gets the value of the campoKey property.
         *
         * @return possible object is {@link CampoKey }
         *
         */
        public String getCampoKey() {
            return campoKey;
        }

        /**
         * Sets the value of the campoKey property.
         *
         * @param value allowed object is {@link CampoKey }
         *
         */
        public void setCampoKey(String value) {
            this.campoKey = value;
        }

        /**
         * Gets the value of the campoXmlMod property.
         *
         * @return possible object is {@link CampoXmlMod }
         *
         */
        public String getCampoXmlMod() {
            return campoXmlMod;
        }

        /**
         * Sets the value of the campoXmlMod property.
         *
         * @param value allowed object is {@link CampoXmlMod }
         *
         */
        public void setCampoXmlMod(String value) {
            this.campoXmlMod = value;
        }

        /**
         * Gets the value of the contatore property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getContatore() {
            return contatore;
        }

        /**
         * Sets the value of the contatore property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setContatore(Integer value) {
            this.contatore = value;
        }

        /**
         * Gets the value of the controllo property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getControllo() {
            return controllo;
        }

        /**
         * Sets the value of the controllo property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setControllo(String value) {
            this.controllo = value;
        }

        /**
         * Gets the value of the decimali property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getDecimali() {
            return decimali;
        }

        /**
         * Sets the value of the decimali property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setDecimali(Integer value) {
            this.decimali = value;
        }

        /**
         * Gets the value of the descrizione property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getDescrizione() {
            return descrizione;
        }

        /**
         * Sets the value of the descrizione property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setDescrizione(String value) {
            this.descrizione = value;
        }

        /**
         * Gets the value of the edit property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getEdit() {
            return edit;
        }

        /**
         * Sets the value of the edit property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setEdit(String value) {
            this.edit = value;
        }

        /**
         * Gets the value of the errMsg property.
         *
         * @return possible object is {@link ErrMsg }
         *
         */
        public String getErrMsg() {
            return errMsg;
        }

        /**
         * Sets the value of the errMsg property.
         *
         * @param value allowed object is {@link ErrMsg }
         *
         */
        public void setErrMsg(String value) {
            this.errMsg = value;
        }

        /**
         * Gets the value of the flgPrecompilazione property.
         *
         * @return possible object is {@link FlgPrecompilazione }
         *
         */
        public String getFlgPrecompilazione() {
            return flgPrecompilazione;
        }

        /**
         * Sets the value of the flgPrecompilazione property.
         *
         * @param value allowed object is {@link FlgPrecompilazione }
         *
         */
        public void setFlgPrecompilazione(String value) {
            this.flgPrecompilazione = value;
        }

        /**
         * Gets the value of the livello property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getLivello() {
            return livello;
        }

        /**
         * Sets the value of the livello property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setLivello(Integer value) {
            this.livello = value;
        }

        /**
         * Gets the value of the lunghezza property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getLunghezza() {
            return lunghezza;
        }

        /**
         * Sets the value of the lunghezza property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setLunghezza(Integer value) {
            this.lunghezza = value;
        }

        /**
         * Gets the value of the marcatoreIncrociato property.
         *
         * @return possible object is {@link MarcatoreIncrociato }
         *
         */
        public String getMarcatoreIncrociato() {
            return marcatoreIncrociato;
        }

        /**
         * Sets the value of the marcatoreIncrociato property.
         *
         * @param value allowed object is {@link MarcatoreIncrociato }
         *
         */
        public void setMarcatoreIncrociato(String value) {
            this.marcatoreIncrociato = value;
        }

        /**
         * Gets the value of the molteplicita property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getMolteplicita() {
            return molteplicita;
        }

        /**
         * Sets the value of the molteplicita property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setMolteplicita(Integer value) {
            this.molteplicita = value;
        }

        /**
         * Gets the value of the nome property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getNome() {
            return nome;
        }

        /**
         * Sets the value of the nome property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setNome(String value) {
            this.nome = value;
        }

        /**
         * Gets the value of the nomeXsd property.
         *
         * @return possible object is {@link NomeXsd }
         *
         */
        public String getNomeXsd() {
            return nomeXsd;
        }

        /**
         * Sets the value of the nomeXsd property.
         *
         * @param value allowed object is {@link NomeXsd }
         *
         */
        public void setNomeXsd(String value) {
            this.nomeXsd = value;
        }

        /**
         * Gets the value of the numCampo property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getNumCampo() {
            return numCampo;
        }

        /**
         * Sets the value of the numCampo property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setNumCampo(Integer value) {
            this.numCampo = value;
        }

        /**
         * Gets the value of the opzioniCombo property.
         *
         * @return possible object is {@link OpzioniCombo }
         *
         */
        public OpzioniComboWrapper getOpzioniCombo() {
            return opzioniCombo;
        }

        /**
         * Sets the value of the opzioniCombo property.
         *
         * @param value allowed object is {@link OpzioniCombo }
         *
         */
        public void setOpzioniCombo(OpzioniComboWrapper value) {
            this.opzioniCombo = value;
        }

        /**
         * Gets the value of the pattern property.
         *
         * @return possible object is {@link Pattern }
         *
         */
        public String getPattern() {
            return pattern;
        }

        /**
         * Sets the value of the pattern property.
         *
         * @param value allowed object is {@link Pattern }
         *
         */
        public void setPattern(String value) {
            this.pattern = value;
        }

        /**
         * Gets the value of the posizione property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getPosizione() {
            return posizione;
        }

        /**
         * Sets the value of the posizione property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setPosizione(Integer value) {
            this.posizione = value;
        }

        /**
         * Gets the value of the precompilazione property.
         *
         * @return possible object is {@link Precompilazione }
         *
         */
        public String getPrecompilazione() {
            return precompilazione;
        }

        /**
         * Sets the value of the precompilazione property.
         *
         * @param value allowed object is {@link Precompilazione }
         *
         */
        public void setPrecompilazione(String value) {
            this.precompilazione = value;
        }

        /**
         * Gets the value of the raggruppamentoCheck property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getRaggruppamentoCheck() {
            return raggruppamentoCheck;
        }

        /**
         * Sets the value of the raggruppamentoCheck property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setRaggruppamentoCheck(String value) {
            this.raggruppamentoCheck = value;
        }

        /**
         * Gets the value of the riga property.
         *
         * @return possible object is {@link Integer }
         *
         */
        public Integer getRiga() {
            return riga;
        }

        /**
         * Sets the value of the riga property.
         *
         * @param value allowed object is {@link Integer }
         *
         */
        public void setRiga(Integer value) {
            this.riga = value;
        }

        /**
         * Gets the value of the tipo property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * Sets the value of the tipo property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

        /**
         * Gets the value of the tpControllo property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTpControllo() {
            return tpControllo;
        }

        /**
         * Sets the value of the tpControllo property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTpControllo(String value) {
            this.tpControllo = value;
        }

        /**
         * Gets the value of the valCampoCollegato property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValCampoCollegato() {
            return valCampoCollegato;
        }

        /**
         * Sets the value of the valCampoCollegato property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setValCampoCollegato(String value) {
            this.valCampoCollegato = value;
        }

        /**
         * Gets the value of the valore property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValore() {
            return valore;
        }

        /**
         * Sets the value of the valore property.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setValore(String value) {
            this.valore = value;
        }

        /**
         * Gets the value of the valoreUtente property.
         *
         * @return possible object is {@link ValoreUtente }
         *
         */
        public String getValoreUtente() {
            return valoreUtente;
        }

        /**
         * Sets the value of the valoreUtente property.
         *
         * @param value allowed object is {@link ValoreUtente }
         *
         */
        public void setValoreUtente(String value) {
            this.valoreUtente = value;
        }

        /**
         * Gets the value of the webServ property.
         *
         * @return possible object is {@link WebServ }
         *
         */
        public String getWebServ() {
            return webServ;
        }

        /**
         * Sets the value of the webServ property.
         *
         * @param value allowed object is {@link WebServ }
         *
         */
        public void setWebServ(String value) {
            this.webServ = value;
        }
    }
}
