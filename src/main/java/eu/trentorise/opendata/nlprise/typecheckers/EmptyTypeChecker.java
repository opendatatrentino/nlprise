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

import javax.annotation.Nullable;

/**
 * Last modified by azanella On 28/gen/2014
 *
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 */
public class EmptyTypeChecker {

    /**
     * Returns true when input is null, empty, or maybe only of spaces.
     */
    public static boolean check(@Nullable String str) {
        if (str == null) {
            return true;
        }
        String tocheck = str.replaceAll(" ", "");
        return tocheck.isEmpty();
    }
}
