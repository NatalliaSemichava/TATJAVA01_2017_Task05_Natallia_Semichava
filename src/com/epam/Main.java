package com.epam;

import com.epam.parsers.DOM.ParserWithDOM;
import com.epam.parsers.SAX.ParserWithSAX;
import com.epam.parsers.StAX.ParserWithStAX;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static String FILENAME = "menu.xml";

    public static void main(String[] args) throws IOException, SAXException, XMLStreamException {
        System.out.println("Hot appetizers with DOM\n");
        ParserWithDOM parserWithDOM = new ParserWithDOM();
        parserWithDOM.readXMLFile(FILENAME, "hot appetizers");

        System.out.println("Cold appetizers with SAX\n");
        ParserWithSAX parserWithSAX = new ParserWithSAX();
        parserWithSAX.readXMLFile(FILENAME, "cold appetizers");

        System.out.println("Breakfasts with StAX\n");
        ParserWithStAX parserWithStAX = new ParserWithStAX();
        parserWithStAX.readXMLFile(FILENAME, "breakfasts");

    }
}
