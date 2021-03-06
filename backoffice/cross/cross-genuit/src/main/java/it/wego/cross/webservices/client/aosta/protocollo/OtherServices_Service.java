
package it.wego.cross.webservices.client.aosta.protocollo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OtherServices", targetNamespace = "http://www.invallee.it/services/OtherServices", wsdlLocation = "http://suic.invallee.it:8081/SW-INVA/services/OtherServices?wsdl")
public class OtherServices_Service
    extends Service
{

    private final static URL OTHERSERVICES_WSDL_LOCATION;
    private final static WebServiceException OTHERSERVICES_EXCEPTION;
    private final static QName OTHERSERVICES_QNAME = new QName("http://www.invallee.it/services/OtherServices", "OtherServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://suic.invallee.it:8081/SW-INVA/services/OtherServices?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OTHERSERVICES_WSDL_LOCATION = url;
        OTHERSERVICES_EXCEPTION = e;
    }

    public OtherServices_Service() {
        super(__getWsdlLocation(), OTHERSERVICES_QNAME);
    }

//    public OtherServices_Service(WebServiceFeature... features) {
//        super(__getWsdlLocation(), OTHERSERVICES_QNAME, features);
//    }

    public OtherServices_Service(URL wsdlLocation) {
        super(wsdlLocation, OTHERSERVICES_QNAME);
    }

//    public OtherServices_Service(URL wsdlLocation, WebServiceFeature... features) {
//        super(wsdlLocation, OTHERSERVICES_QNAME, features);
//    }

    public OtherServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

//    public OtherServices_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     * 
     * @return
     *     returns OtherServices
     */
    @WebEndpoint(name = "OtherServicesImplPort")
    public OtherServices getOtherServicesImplPort() {
        return super.getPort(new QName("http://www.invallee.it/services/OtherServices", "OtherServicesImplPort"), OtherServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OtherServices
     */
    @WebEndpoint(name = "OtherServicesImplPort")
    public OtherServices getOtherServicesImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.invallee.it/services/OtherServices", "OtherServicesImplPort"), OtherServices.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OTHERSERVICES_EXCEPTION!= null) {
            throw OTHERSERVICES_EXCEPTION;
        }
        return OTHERSERVICES_WSDL_LOCATION;
    }

}
