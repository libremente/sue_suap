/**
 * WSCheckInService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.wego.cross.client.stub.checkin;

public interface WSCheckInService extends javax.xml.rpc.Service {
    public java.lang.String getWSCheckInAddress();

    public it.wego.cross.client.stub.checkin.WSCheckIn getWSCheckIn() throws javax.xml.rpc.ServiceException;

    public it.wego.cross.client.stub.checkin.WSCheckIn getWSCheckIn(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}