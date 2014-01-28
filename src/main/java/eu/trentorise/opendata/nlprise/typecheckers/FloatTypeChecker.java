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

/**
 * @author Alberto Zanella <a.zanella@trentorise.eu>
 * @since Last modified by azanella On 28/gen/2014
 *
 */
public class FloatTypeChecker {
	public static boolean check(String str)
	{
		try {
			String toCheck = str;
			if (toCheck.contains(".") && (toCheck.contains(","))
					&& (toCheck.lastIndexOf(',') < toCheck.lastIndexOf('.'))) {
				{
					toCheck = toCheck.replace(",", "");
				}
			}
			Double.parseDouble(toCheck);
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}