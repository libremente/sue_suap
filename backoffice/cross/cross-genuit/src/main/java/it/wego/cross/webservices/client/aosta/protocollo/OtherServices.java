
package it.wego.cross.webservices.client.aosta.protocollo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OtherServices", targetNamespace = "http://swinva.invallee.it/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OtherServices {


    /**
     * 
     * @param dataFine
     * @param dataInizio
     * @return
     *     returns it.wego.cross.webservices.client.aosta.protocollo.DettaglioProtocolloArray
     */
    @WebMethod(action = "urn:ricercaProtocollo")
    @WebResult(name = "dettagliProtocollo", partName = "dettagliProtocollo")
    @Action(input = "urn:ricercaProtocollo", output = "http://swinva.invallee.it/OtherServices/ricercaProtocolloResponse")
    public DettaglioProtocolloArray ricercaProtocollo(
        @WebParam(name = "dataInizio", partName = "dataInizio")
        XMLGregorianCalendar dataInizio,
        @WebParam(name = "dataFine", partName = "dataFine")
        XMLGregorianCalendar dataFine);

}
