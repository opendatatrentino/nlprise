/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.opendata.nlprise.typecheckers;

/**
 * Last modified on 10 Feb 2014
 * @author David Leoni
 */
public class ListTypeChecker {

    /**
     * Checks if parameter str is a list.
     * @param str any string.
     * @return true if input string contains a list of comma separated groups of
     * at most four words separated by spaces. In example: for input "ab, cd ef, gh i
     * l, mno" the output is true, while for input "a,b c d e f, gh" the output is false, because the second group
     * contains more than four words. Word can only contain alphanumeric characters.
     */
    public static boolean check(String str) {
        String[] tokens = str.split(",");
        if (tokens.length == 0) {
            return false;
        }
        for (String t : tokens) {
            if (t.split(" ").length > 4) {
                return false;
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);

                if (!(Character.isAlphabetic(c) || Character.isDigit(c) || Character.isWhitespace(c))) {
                    return false;
                }
            }
        }
        return true;
    }

}
