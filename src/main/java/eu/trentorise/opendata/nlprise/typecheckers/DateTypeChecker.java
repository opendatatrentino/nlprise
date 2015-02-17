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
/**
 *
 */
package eu.trentorise.opendata.nlprise.typecheckers;

import eu.trentorise.opendata.nlprise.identifiers.date.DateIdentifier;
import javax.annotation.Nullable;

/**
 *
 *
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 * @author David Leoni <david.leoni@unitn.it> 
 */
public class DateTypeChecker {

    private static final int MAX_DATE_SIZE = 30;

    public static boolean check(@Nullable String str) {
        if (str == null) {
            return false;
        }
        if (str.length() > MAX_DATE_SIZE) {
            return false;
        }
        String toCheck = str.replaceAll("[^\\w\\s]", "");
        return (DateIdentifier.isADate(toCheck).getResult());
    }
}
