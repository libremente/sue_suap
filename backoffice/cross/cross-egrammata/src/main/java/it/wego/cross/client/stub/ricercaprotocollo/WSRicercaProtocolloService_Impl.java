// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3
package it.wego.cross.client.stub.ricercaprotocollo;

import com.sun.xml.rpc.client.ServiceExceptionImpl;
import com.sun.xml.rpc.util.exception.*;
import com.sun.xml.rpc.client.HandlerChainImpl;
import javax.xml.rpc.*;
import javax.xml.namespace.QName;

public class WSRicercaProtocolloService_Impl extends com.sun.xml.rpc.client.BasicService implements WSRicercaProtocolloService {

    private static final QName serviceName = new QName("http://protocollotest.comune.genova.it/axis/services/WSRicercaProtocollo", "WSRicercaProtocolloService");
    private static final QName ns1_WSRicercaProtocollo_QNAME = new QName("http://protocollotest.comune.genova.it/axis/services/WSRicercaProtocollo", "WSRicercaProtocollo");
    private static final Class WSRicercaProtocollo_PortClass = it.wego.cross.client.stub.ricercaprotocollo.WSRicercaProtocollo.class;

    public WSRicercaProtocolloService_Impl() {
        super(serviceName, new QName[]{
                    ns1_WSRicercaProtocollo_QNAME
                },
                new it.wego.cross.client.stub.ricercaprotocollo.WSRicercaProtocolloService_SerializerRegistry().getRegistry());

    }

    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, java.lang.Class serviceDefInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (portName.equals(ns1_WSRicercaProtocollo_QNAME)
                    && serviceDefInterface.equals(WSRicercaProtocollo_PortClass)) {
                return getWSRicercaProtocollo(null);
            }
        } catch (Exception e) {
            throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(e));
        }
        return super.getPort(portName, serviceDefInterface);
    }

    public java.rmi.Remote getPort(java.lang.Class serviceDefInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serviceDefInterface.equals(WSRicercaProtocollo_PortClass)) {
                return getWSRicercaProtocollo(null);
            }
        } catch (Exception e) {
            throw new ServiceExceptionImpl(new LocalizableExceptionAdapter(e));
        }
        return super.getPort(serviceDefInterface);
    }

    public it.wego.cross.client.stub.ricercaprotocollo.WSRicercaProtocollo getWSRicercaProtocollo(Integer timeout) {
        java.lang.String[] roles = new java.lang.String[]{};
        HandlerChainImpl handlerChain = new HandlerChainImpl(getHandlerRegistry().getHandlerChain(ns1_WSRicercaProtocollo_QNAME));
        handlerChain.setRoles(roles);
        it.wego.cross.client.stub.ricercaprotocollo.WSRicercaProtocollo_Stub stub = new it.wego.cross.client.stub.ricercaprotocollo.WSRicercaProtocollo_Stub(handlerChain, timeout);
        try {
            stub._initialize(super.internalTypeRegistry);
        } catch (JAXRPCException e) {
            throw e;
        } catch (Exception e) {
            throw new JAXRPCException(e.getMessage(), e);
        }
        return stub;
    }
}