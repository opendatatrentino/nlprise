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
import javax.annotation.Nullable;
import static org.parboiled.common.Preconditions.checkNotNull;


/**
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 *
 */
public class DataTypeGuess {

	/**
	 * Defines supported data types
	 * 
	 * @author Alberto Zanella <a.zanella@trentorise.eu> 
         * @author David Leoni <david.leoni@unitn.it> 
	 */
	public enum Datatype {
		INT, FLOAT, DATE, STRING, GEOJSON, XML, JSON, LIST, NL_STRING , EMPTY;
	}
	
	public static Datatype guessType(@Nullable String str) {
		if (EmptyTypeChecker.check(str)) {
			return Datatype.EMPTY;
		}
                String nonEmptyStr = checkNotNull(str);
                
		if (IntTypeChecker.check(nonEmptyStr)) {
			return Datatype.INT;
		}
		if (FloatTypeChecker.check(nonEmptyStr)) {
			return Datatype.FLOAT;
		}
		if (DateTypeChecker.check(nonEmptyStr)) {
			return Datatype.DATE;
		}
                if (XmlTypeChecker.check(nonEmptyStr)){
                    return Datatype.XML;
                }
                if (JsonTypeChecker.check(nonEmptyStr)){
                return Datatype.JSON;
                }
                if (ListTypeChecker.check(nonEmptyStr)){
                    return Datatype.LIST;
                }
                if (nonEmptyStr.length() > 20 && nonEmptyStr.contains(" ")){
                    return Datatype.NL_STRING;
                }
		return Datatype.STRING;
	}
                

}
