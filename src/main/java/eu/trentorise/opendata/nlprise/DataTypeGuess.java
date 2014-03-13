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
package eu.trentorise.opendata.nlprise;
import eu.trentorise.opendata.nlprise.typecheckers.DateTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.EmptyTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.FloatTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.IntTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.JsonTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.ListTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.XmlTypeChecker;


/**
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 *
 */
public class DataTypeGuess {

	/**
	 * Defines supported data types
	 * 
	 * @author Alberto Zanella <a.zanella@trentorise.eu> Last modified by
	 *         azanella On 11/lug/2013
	 */
	public enum Datatype {
		INT, FLOAT, DATE, STRING, GEOJSON, XML, JSON, LIST, NL_STRING , EMPTY;
	}
	
	public static Datatype guessType(String str) {
		if (EmptyTypeChecker.check(str)) {
			return Datatype.EMPTY;
		}
		if (IntTypeChecker.check(str)) {
			return Datatype.INT;
		}
		if (FloatTypeChecker.check(str)) {
			return Datatype.FLOAT;
		}
		if (DateTypeChecker.check(str)) {
			return Datatype.DATE;
		}
                if (XmlTypeChecker.check(str)){
                    return Datatype.XML;
                }
                if (JsonTypeChecker.check(str)){
                return Datatype.JSON;
                }
                if (ListTypeChecker.check(str)){
                    return Datatype.LIST;
                }
                if (str.length() > 20 && str.contains(" ")){
                    return Datatype.NL_STRING;
                }
		return Datatype.STRING;
	}
                

}
