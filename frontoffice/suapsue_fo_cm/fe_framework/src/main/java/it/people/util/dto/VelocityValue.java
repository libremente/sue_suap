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
/**
 * 
 */
package it.people.util.dto;

/**
 * @author Riccardo Forafò - Engineering Ingegneria Informatica - Genova
 *         08/ott/2012 22:06:52
 */
public class VelocityValue {

    private String parameterKey;

    private String parameterValue;

    /**
     * @param velocityParameter
     * @param parameterValue
     */
    public VelocityValue(final String parameterKey, final String parameterValue) {
	this.setParameterKey(parameterKey);
	this.setParameterValue(parameterValue);
    }

    /**
     * @param parameterKey
     *            the parameterKey to set
     */
    private void setParameterKey(String parameterKey) {
	this.parameterKey = parameterKey;
    }

    /**
     * @param parameterValue
     *            the parameterValue to set
     */
    private void setParameterValue(String parameterValue) {
	this.parameterValue = parameterValue;
    }

    /**
     * @return the parameterKey
     */
    public final String getParameterKey() {
	return this.parameterKey;
    }

    /**
     * @return the parameterValue
     */
    public final String getParameterValue() {
	return this.parameterValue;
    }

}
