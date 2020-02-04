/**
 * Copyright (c) 2011, Regione Emilia-Romagna, Italy
 *  
 * Licensed under the EUPL, Version 1.1 or - as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the
 * Licence.
 * 
 * For convenience a plain text copy of the English version
 * of the Licence can be found in the file LICENCE.txt in
 * the top-level directory of this software distribution.
 * 
 * You may obtain a copy of the Licence in any of 22 European
 * Languages at:
 * 
 * http://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in
 * writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied.
 * 
 * This product includes software developed by Yale University
 * 
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
**/
/*

  Licenza:	    Licenza Progetto PEOPLE
  Fornitore:    CEFRIEL
  Autori:       M. Pianciamore, P. Selvini

  Questo codice sorgente � protetto dalla licenza valida nell'ambito del
  progetto PEOPLE. La propriet� intellettuale di questo codice � e rester�
  esclusiva di "CEFRIEL Societ� Consortile a Responsabilit� Limitata" con
  sede legale in via Renato Fucini 2, 20133 Milano (MI).

  Disclaimer:

  COVERED CODE IS PROVIDED UNDER THIS LICENSE ON AN "AS IS" BASIS, WITHOUT
  WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT 
  LIMITATION, WARRANTIES THAT THE COVERED CODE IS FREE OF DEFECTS, MERCHANTABLE,
  FIT FOR A PARTICULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE
  QUALITY AND PERFORMANCE OF THE COVERED CODE IS WITH YOU. SHOULD ANY COVERED
  CODE PROVE DEFECTIVE IN ANY RESPECT, YOU (NOT THE INITIAL DEVELOPER OR ANY
  OTHER CONTRIBUTOR) ASSUME THE COST OF ANY NECESSARY SERVICING, REPAIR OR
  CORRECTION.
    
*/

package it.people.sirac.idp.registration;

import it.people.sirac.idp.beans.RegBean;
import it.people.sirac.idp.beans.ResRegBean;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegistrationImplDB_MySQL extends RegistrationImplDB {

  private static final Logger logger = LoggerFactory.getLogger(RegistrationImplDB_MySQL.class);

  /*
   * submits a User update request to the Registration service
   * Returns a ResRegBean object containing the response
  */
  public ResRegBean updateRegistration(RegBean userRegistrationData) throws RemoteException {
    ResRegBean response = new ResRegBean();

    if(userRegistrationData == null){
    	throw new RemoteException("updateRegistration(). Dati di registrazioni non validi: " + userRegistrationData);
    }
    
    Date now = new Date();
    Connection conn = null;
    Statement statement = null;
    
    response.setTimestamp(now.toString());
    
    try{
      
      if(!isUserRegistered(userRegistrationData.getCodiceFiscale())){
      	logger.debug("Impossibile aggiornare l'utente. Il codice fiscale = " + userRegistrationData.getCodiceFiscale() + " non esiste nel DB.");    
        response.setEsito("FAILED");
        response.setMessaggio(MSG_USERNOTEXISTENT);
        response.setErrorCode(ECODE_USERNOTEXISTENT);
        return response;
      } else {
      	conn = getConnection();
      	statement = conn.createStatement();
        String dbQuery = "UPDATE USERDATA SET ";
        dbQuery += "NOME = \"" + userRegistrationData.getNome() + "\",";
        dbQuery += "COGNOME = \"" + userRegistrationData.getCognome() + "\",";
        dbQuery += "DATA_NASCITA = \"" + userRegistrationData.getDataNascita() + "\",";
        dbQuery += "CAP_DOMICILIO = \"" + userRegistrationData.getCapDomicilio() + "\",";
        dbQuery += "CAP_RESIDENZA = \"" + userRegistrationData.getCapResidenza() + "\",";
        dbQuery += "CITTA_DOMICILIO = \"" + userRegistrationData.getCittaDomicilio() + "\",";
        dbQuery += "CITTA_RESIDENZA = \"" + userRegistrationData.getCittaResidenza() + "\",";
        dbQuery += "INDIRIZZO_DOMICILIO = \"" + userRegistrationData.getIndirizzoDomicilio() + "\",";
        dbQuery += "INDIRIZZO_RESIDENZA = \"" + userRegistrationData.getIndirizzoResidenza() + "\",";
        dbQuery += "LAVORO = \"" + userRegistrationData.getLavoro() + "\",";
        dbQuery += "LUOGO_NASCITA = \"" + userRegistrationData.getLuogoNascita() + "\",";
        dbQuery += "PROVINCIA_DOMICILIO = \"" + userRegistrationData.getProvinciaDomicilio() + "\",";
        dbQuery += "PROVINCIA_NASCITA = \"" + userRegistrationData.getProvinciaNascita() + "\",";
        dbQuery += "PROVINCIA_RESIDENZA = \"" + userRegistrationData.getProvinciaResidenza() + "\",";
        dbQuery += "SESSO = \"" + userRegistrationData.getSesso() + "\",";
        dbQuery += "STATO_DOMICILIO = \"" + userRegistrationData.getStatoDomicilio() + "\",";
        dbQuery += "STATO_RESIDENZA = \"" + userRegistrationData.getStatoResidenza() + "\",";
        dbQuery += "STATO_NASCITA = \"" + userRegistrationData.getStatoNascita() + "\",";
        dbQuery += "TELEFONO = \"" + userRegistrationData.getTelefono() + "\",";
        dbQuery += "CELLULARE = \"" + userRegistrationData.getCellulare() + "\",";
        dbQuery += "TITOLO = \"" + userRegistrationData.getTitolo() + "\",";
        dbQuery += "E_MAIL = \"" + userRegistrationData.getEmail() + "\"";
        dbQuery += "WHERE CODICE_FISCALE = \"" + userRegistrationData.getCodiceFiscale().toUpperCase() + "\"";
;
        if(logger.isDebugEnabled())
           logger.debug("updateRegistration - Codice fiscale = "+userRegistrationData.getCodiceFiscale()+", Nome = "+userRegistrationData.getNome()+", Cognome = "+userRegistrationData.getCognome()+", Nascita = "+userRegistrationData.getDataNascita());
       
        int result = statement.executeUpdate(dbQuery);

        if(result == 1) {
        
          if(logger.isDebugEnabled())
            logger.debug("Utente aggiornato.");
          
          response.setEsito("OK");
          response.setMessaggio(MSG_CREATESUCCESS);
          response.setErrorCode(ECODE_CREATESUCCESS);
          response.setCodiceFiscale(userRegistrationData.getCodiceFiscale().toUpperCase());
          response.setUserId(userRegistrationData.getCodiceFiscale().toUpperCase());
          
          return response;
        } else {

          if(logger.isDebugEnabled())
        	  logger.debug("Errore durante l'aggiornamento dell'utente.");
        	
       	  response.setEsito("FAILED");
       	  response.setMessaggio(MSG_UPDATEFAILED);
       	  response.setErrorCode(ECODE_UPDATEFAILED);
 
          return response;
        }
      }    
    } catch (Exception e) {
      logger.error("executeRegistration - exception: " + e.getMessage());
      if(logger.isDebugEnabled()) {
				StringWriter w = new StringWriter();
				e.printStackTrace(new PrintWriter(w));
				logger.error("Exception stack:\n"+w);
      }
    	
      response.setEsito("FAILED");
      response.setMessaggio(MSG_UPDATEFAILED);
      response.setErrorCode(ECODE_UPDATEFAILED);
    	
      return response;
    } finally {
      try {
    	  statement.close();
        conn.close();
      } catch (SQLException e) {
        logger.error("executeRegistration() - Can't close connection: " + e.getMessage());
      }
    } 
   
  }
  
  /*
   * submits a User Registration request to the Registration service
   * Returns a ResRegBean object containing the response
  */
  public ResRegBean executeRegistration(RegBean userRegistrationData) throws RemoteException {
    ResRegBean response = new ResRegBean();

    Date now = new Date();
    Connection conn = null;
    ResultSet userdbResultset = null;
    
    response.setTimestamp(now.toString());
    
    try{
      conn = getConnection();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      
      String preQuery = "SELECT CODICE_FISCALE FROM USERDATA WHERE CODICE_FISCALE=\"" + userRegistrationData.getCodiceFiscale().toUpperCase() + "\"";
      
      Statement statement = conn.createStatement();
      userdbResultset = statement.executeQuery(preQuery);
      if (userdbResultset.next()) {
        logger.debug("Impossibile aggiungere l'utente. Il codice fiscale = " + userRegistrationData.getCodiceFiscale() + " � gi� presente nel DB.");    
        
        response.setEsito("FAILED");
        response.setMessaggio(MSG_USERALREADYPRESENT);
        response.setErrorCode(ECODE_USERALREADYPRESENT);
        
        return response;
        
      } else{
      
        String dbQuery = "INSERT INTO USERDATA (CODICE_FISCALE, CARTA_IDENTITA, NOME, COGNOME, DATA_NASCITA, CAP_DOMICILIO, ";
        dbQuery += "CAP_RESIDENZA, CITTA_DOMICILIO, CITTA_RESIDENZA, INDIRIZZO_DOMICILIO, INDIRIZZO_RESIDENZA, LAVORO, ";
        dbQuery += "LUOGO_NASCITA, PROVINCIA_DOMICILIO, PROVINCIA_NASCITA, PROVINCIA_RESIDENZA, SESSO, STATO_DOMICILIO, ";
        dbQuery += "STATO_RESIDENZA, STATO_NASCITA, TELEFONO, CELLULARE, TITOLO, E_MAIL, DOMICILIO_ELETTRONICO, ";
        dbQuery += "ID_COMUNE, PASSWORD, PIN, DATA_REGISTRAZIONE, STATUS) VALUES(";
   
        dbQuery += "\"" + userRegistrationData.getCodiceFiscale().toUpperCase() + "\",";
        dbQuery += "\"" + userRegistrationData.getCartaIdentita() + "\",";
        dbQuery += "\"" + userRegistrationData.getNome() + "\",";
        dbQuery += "\"" + userRegistrationData.getCognome() + "\",";
        dbQuery += "\"" + userRegistrationData.getDataNascita() + "\",";
        dbQuery += "\"" + userRegistrationData.getCapDomicilio() + "\",";
        dbQuery += "\"" + userRegistrationData.getCapResidenza() + "\",";
        dbQuery += "\"" + userRegistrationData.getCittaDomicilio() + "\",";
        dbQuery += "\"" + userRegistrationData.getCittaResidenza() + "\",";
        dbQuery += "\"" + userRegistrationData.getIndirizzoDomicilio() + "\",";
        dbQuery += "\"" + userRegistrationData.getIndirizzoResidenza() + "\",";
        dbQuery += "\"" + userRegistrationData.getLavoro() + "\",";
        dbQuery += "\"" + userRegistrationData.getLuogoNascita() + "\",";
        dbQuery += "\"" + userRegistrationData.getProvinciaDomicilio() + "\",";
        dbQuery += "\"" + userRegistrationData.getProvinciaNascita() + "\",";
        dbQuery += "\"" + userRegistrationData.getProvinciaResidenza() + "\",";
        dbQuery += "\"" + userRegistrationData.getSesso() + "\",";
        dbQuery += "\"" + userRegistrationData.getStatoDomicilio() + "\",";
        dbQuery += "\"" + userRegistrationData.getStatoResidenza() + "\",";
        dbQuery += "\"" + userRegistrationData.getStatoNascita() + "\",";
        dbQuery += "\"" + userRegistrationData.getTelefono() + "\",";
        dbQuery += "\"" + userRegistrationData.getCellulare() + "\",";
        dbQuery += "\"" + userRegistrationData.getTitolo() + "\",";
        dbQuery += "\"" + userRegistrationData.getEmail() + "\",";
        dbQuery += "\"" + userRegistrationData.getDomicilioElettronico() + "\",";
        dbQuery += "\"" + userRegistrationData.getIdComune() + "\",";
        dbQuery += "\"" + userRegistrationData.getPassword() + "\",";
        dbQuery += "\"" + userRegistrationData.getPin() + "\",";
        dbQuery += "\"" + sdf.format(now) + "\",";
        dbQuery += "\"INATTIVO\")";
            
        if(logger.isDebugEnabled())
           logger.debug("Aggiunta utente: CodFis = "+userRegistrationData.getCodiceFiscale()+", Nome = "+userRegistrationData.getNome()+", Cognome = "+userRegistrationData.getCognome()+", Nascita = "+userRegistrationData.getDataNascita());
       
        int result = statement.executeUpdate(dbQuery);
      
        statement.close();
        
        if(result == 1){
        
          if(logger.isDebugEnabled())
            logger.debug("Utente registrato.");
          
          response.setEsito("OK");
          response.setMessaggio(MSG_CREATESUCCESS);
          response.setErrorCode(ECODE_CREATESUCCESS);
          response.setCodiceFiscale(userRegistrationData.getCodiceFiscale().toUpperCase());
          response.setUserId(userRegistrationData.getCodiceFiscale().toUpperCase());
          return response;
        } else{
          throw new Exception("Errore duranta l'inserimento dei dati nel DB. Query: " + dbQuery);
        }
      }    
    } catch (Exception e) {
      logger.error("executeRegistration - exception: " + e.getMessage());
    	if(logger.isDebugEnabled())
    	{
    		StringWriter w = new StringWriter();
    		e.printStackTrace(new PrintWriter(w));
    		
    		logger.error("Exception stack:\n"+w);
    	}
    	
    	response.setEsito("FAILED");
    	response.setMessaggio(MSG_CREATEFAILED);
    	response.setErrorCode(ECODE_CREATEFAILED);
    	
    	return response;
    } finally {
      try {
        conn.close();
      } catch (SQLException e) {
          logger.error("executeRegistration() - Can't close connection: " + e.getMessage());
      }
    } 
   
  }
  
  /*
   * activate the specified user
   * Returns a ResRegBean object containing the response
  */
  public ResRegBean activateUser(String codiceFiscale) throws RemoteException {

    if(codiceFiscale == null){
    	throw new RemoteException("activateUser(). Codice fiscale non valido: " + codiceFiscale);
    }

    ResRegBean response = new ResRegBean();
    Date now = new Date();
    Connection conn = null;
    Statement statement = null;
    
    response.setTimestamp(now.toString());
    
    try{
      if(!isUserRegistered(codiceFiscale)){
      	logger.debug("activateUser() - Impossibile attivare l'utente. Il codice fiscale = " + codiceFiscale + " non esiste nel DB.");    
        response.setEsito("FAILED");
        response.setMessaggio(MSG_USERNOTEXISTENT);
        response.setErrorCode(ECODE_USERNOTEXISTENT);
        return response;
      } else {
    	  conn = getConnection();
        statement = conn.createStatement();
        String dbQuery = "UPDATE USERDATA SET STATUS = \"ATTIVO\", ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dbQuery+="DATA_ATTIVAZIONE = \"" + sdf.format(now) + "\"";
        dbQuery+=" WHERE CODICE_FISCALE = \"" + codiceFiscale.toUpperCase() + "\"";
        int result = statement.executeUpdate(dbQuery);
        if(result == 1) {
	      	if(logger.isDebugEnabled())
	      		logger.debug("Utente attivato.");
	        
	      	response.setEsito("OK");
		      response.setMessaggio(MSG_ACTIVATIONSUCCESS);
		      response.setErrorCode(ECODE_ACTIVATIONSUCCESS);
		      response.setCodiceFiscale(codiceFiscale.toUpperCase());
		      response.setUserId(codiceFiscale.toUpperCase());
		      return response;
        } else {
	        if(logger.isDebugEnabled())
	      	  logger.debug("activateUser() - Errore durante l'aggiornamento dell'utente.");
		     	  response.setEsito("FAILED");
		     	  response.setMessaggio(MSG_ACTIVATIONFAILED);
		     	  response.setErrorCode(ECODE_ACTIVATIONFAILED);
	          return response;
	        }
      }
  	} catch (Exception e) {
	    logger.error("activateUser() - exception: " + e.getMessage());
	    if(logger.isDebugEnabled()) {
				StringWriter w = new StringWriter();
				e.printStackTrace(new PrintWriter(w));
				logger.error("Exception stack:\n"+w);
	    }
	  	
	    response.setEsito("FAILED");
	    response.setMessaggio(MSG_ACTIVATIONFAILED);
	    response.setErrorCode(ECODE_ACTIVATIONFAILED);
	  	
	    return response;
	  } finally {
	    try {
	  	  statement.close();
	      conn.close();
	    } catch (SQLException e) {
	      logger.error("activateUser() - Can't close connection: " + e.getMessage());
	    }
	  } 
 
  }

}