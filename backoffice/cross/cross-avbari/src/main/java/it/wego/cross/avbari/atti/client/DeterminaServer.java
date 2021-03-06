package it.wego.cross.avbari.atti.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.9
 * 2015-02-17T11:54:00.256+01:00
 * Generated source version: 2.3.9
 * 
 */
@WebService(targetNamespace = "http://server.ws.amministrazioneatti.avt.linksmt.it/", name = "DeterminaServer")
@XmlSeeAlso({ObjectFactory.class})
public interface DeterminaServer {

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "return", output = "http://server.ws.amministrazioneatti.avt.linksmt.it/DeterminaServer/getDocumentoDeterminaResponse")
    @RequestWrapper(localName = "getDocumentoDetermina", targetNamespace = "http://server.ws.amministrazioneatti.avt.linksmt.it/", className = "it.wego.cross.avbari.atti.client.GetDocumentoDetermina")
    @WebMethod(action = "return")
    @ResponseWrapper(localName = "getDocumentoDeterminaResponse", targetNamespace = "http://server.ws.amministrazioneatti.avt.linksmt.it/", className = "it.wego.cross.avbari.atti.client.GetDocumentoDeterminaResponse")
    public it.wego.cross.avbari.atti.client.GetDocumentoDeterminaResponse.Return getDocumentoDetermina(
        @WebParam(name = "documentoDeterminaRequest", targetNamespace = "")
        it.wego.cross.avbari.atti.client.GetDocumentoDetermina.DocumentoDeterminaRequest documentoDeterminaRequest
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "return", output = "http://server.ws.amministrazioneatti.avt.linksmt.it/DeterminaServer/getAllegatiDeterminaResponse")
    @RequestWrapper(localName = "getAllegatiDetermina", targetNamespace = "http://server.ws.amministrazioneatti.avt.linksmt.it/", className = "it.wego.cross.avbari.atti.client.GetAllegatiDetermina")
    @WebMethod(action = "return")
    @ResponseWrapper(localName = "getAllegatiDeterminaResponse", targetNamespace = "http://server.ws.amministrazioneatti.avt.linksmt.it/", className = "it.wego.cross.avbari.atti.client.GetAllegatiDeterminaResponse")
    public it.wego.cross.avbari.atti.client.GetAllegatiDeterminaResponse.Return getAllegatiDetermina(
        @WebParam(name = "allegatiDeterminaRequest", targetNamespace = "")
        it.wego.cross.avbari.atti.client.GetAllegatiDetermina.AllegatiDeterminaRequest allegatiDeterminaRequest
    );
}
