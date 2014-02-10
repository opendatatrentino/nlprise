/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.trentorise.opendata.nlprise.typecheckers;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Last modified on 10 Feb 2014
 * @author David Leoni
 */
public class JsonTypeChecker {
    /**
     * Checks if parameter str is a json.
     * @param s any string.
     * @return true if given string is a well formed json. 
     */
    public static boolean check(String s){
        
        String ns = s.trim();
        
        if (!(ns.startsWith("{") || ns.startsWith("["))){
            return false;
        }
        
        ObjectMapper om = new ObjectMapper();
        try {
            om.readTree(s.trim());
            return true;
        } catch (IOException ex) {
            
        }
        return false;
    }
}
