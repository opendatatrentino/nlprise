/**
* *****************************************************************************
* Copyright 2012-2013 Trento Rise (www.trentorise.eu/)
*
* All rights reserved. This program and the accompanying materials are made
* available under the terms of the GNU Lesser General Public License (LGPL)
* version 2.1 which accompanies this distribution, and is available at
*
* http://www.gnu.org/licenses/lgpl-2.1.html
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*
*******************************************************************************
*/
package eu.trentorise.opendata.nlprise.identifiers.date;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent the response from the DateParser.isDate()
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 * Last modified by azanella On 08/lug/2013
 */
public class Response {
	/**
	 * Contains parser used to identify date. INTERNAL is the parser.ItalianDateParser
	 * @author Alberto Zanella <a.zanella@trentorise.eu>
	 *
	 */
	public enum DateParser { INTERNAL, JCHRONIC, POJAVA;}
		
	private boolean result;
	private Map<DateParser, Boolean> singleParserReturn;
	
	/**
	 * 
	 * @return if the string passed was identified as a Date by at least one parser
	 */
	public boolean getResult() {
		return result;
	}
	/**
	 * 
	 * @return an HashMap containing the parser as the key and the result of the evaluation (boolean) as value
	 */
	public Map<DateParser, Boolean> getSingleParserReturn() {
		return singleParserReturn;
	}
	protected void setResult(boolean result) {
		this.result = result;
	}
	protected void setSingleParserReturn(
			HashMap<DateParser, Boolean> singleParserReturn) {
		this.singleParserReturn = singleParserReturn;
	}
	
}
