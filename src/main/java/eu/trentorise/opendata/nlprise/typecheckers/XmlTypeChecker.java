/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.trentorise.opendata.nlprise.typecheckers;

import eu.trentorise.opendata.nlprise.NlpriseException;
import java.io.IOException;
import java.io.StringReader;
import javax.annotation.Nullable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author David Leoni <david.leoni@unitn.it> 
 */
public class XmlTypeChecker {

    /**
     * @param s a string that might contain an xml.
     * @return true if s is a well formed xml. Doesn't check for schema.
     */
    public static boolean check(@Nullable String s) {
        if (s == null) {
            return false;
        }
        String ts = s.trim();
        if (ts.startsWith("<")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);

            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                throw new NlpriseException("Couldn't initialize xml document builder.", ex);
            }

            builder.setErrorHandler(new SimpleErrorHandler());
            try {
                // the "parse" method also validates XML, will throw an exception if misformatted
                Document document = builder.parse(new InputSource(new StringReader(ts)));
                return true;
            } catch (IOException ex) {
            } catch (SAXException ex) {
            }
        }
        return false;
    }

    /**
     * Actually not so useful
     *
     * @author David Leoni
     */
    private static class SimpleErrorHandler implements ErrorHandler {

        @Override
        public void warning(SAXParseException e) throws SAXException {
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            throw e;
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            throw e;
        }
    }
}
