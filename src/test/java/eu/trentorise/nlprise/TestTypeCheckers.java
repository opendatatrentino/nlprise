/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.nlprise;

import eu.trentorise.opendata.nlprise.DataTypeGuess;
import eu.trentorise.opendata.nlprise.DataTypeGuess.Datatype;
import eu.trentorise.opendata.nlprise.typecheckers.JsonTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.ListTypeChecker;
import eu.trentorise.opendata.nlprise.typecheckers.XmlTypeChecker;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Last modified on 10 Feb 2014
 * @author David Leoni
 */
public class TestTypeCheckers {

    @Test
    public void testCheckList() {
        assertTrue(ListTypeChecker.check("ab, cd ef, gh i l, mno "));
    }

    @Test
    public void testCheckListLongWords() {
        assertFalse(ListTypeChecker.check("a,b c d e f, gh"));
    }

    @Test
    public void testCheckXml() {
        assertTrue(XmlTypeChecker.check("  <a><b></b></a>"));
    }

    @Test
    public void testCheckNotXml() {
        assertFalse(XmlTypeChecker.check("<a><b></a>"));
    }

    @Test
    public void testCheckJson() {
        assertTrue(JsonTypeChecker.check(" {\"a\":5}"));
    }

    @Test
    public void testCheckNotJson() {
        assertFalse(JsonTypeChecker.check("4"));
    }

    @Test
    public void testGuessNaturalLanguage() {
        assertEquals(Datatype.NL_STRING, DataTypeGuess.guessType("Golden Delicious: forma tronco-conica oblunga e colore dal verde al giallo, a volte con faccetta rosata. La polpa è croccante e succosa, con un peculiare sapore dolce-acidulo.Red Delicous: colore rosso su fondo verde."));
    }

    /**
     * Not a list because contains non-alpanumeric characters
     */
    @Test
    public void testGuessNaturalLanguageNonAlphanumeric() {
        assertEquals(Datatype.NL_STRING, DataTypeGuess.guessType("Golden Delicious, pere, mele, frutta e ortaggi, {capperi: spaziali}"));
    }

    /**
     * Not natural language because it contains a non-alphanumeric character
    */
    @Test
    public void testString() {
        assertEquals(Datatype.STRING, DataTypeGuess.guessType("<,e,w , e"));
    }    

}
