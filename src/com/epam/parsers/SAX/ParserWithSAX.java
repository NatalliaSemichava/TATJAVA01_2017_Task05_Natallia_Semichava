package com.epam.parsers.SAX;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class ParserWithSAX {


    public void readXMLFile(String url, String type) throws SAXException, IOException {

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MenuSAXHandler handler = new MenuSAXHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource(url));

        System.out.println(handler.getDishArrayList(type)+"\n");
    }
}
