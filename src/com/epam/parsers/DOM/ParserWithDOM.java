package com.epam.parsers.DOM;


import com.epam.bean.*;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class ParserWithDOM {
    private Menu menu = new Menu();

    public void readXMLFile(String url, String type) throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse(url);
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();

        NodeList categorySet = root.getElementsByTagName("category");
        for (int i = 0; i < categorySet.getLength(); i++) {
            String category = categorySet.item(i).getAttributes().getNamedItem("name").getNodeValue();

            ArrayList<Dish> dishArrayList = new ArrayList<>();
            NodeList dishSet = categorySet.item(i).getChildNodes();
            for (int j = 0; j < dishSet.getLength(); j++) {
                Node n = dishSet.item(j);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    dishArrayList.add(getDish(n));
                }
            }
            menu.addCategory(category, dishArrayList);
        }
        System.out.println(menu.showCategory(type) + "\n");
    }

    private Dish getDish(Node n) {
        Dish dish = new Dish();
        dish.setName(getText("name", n));
        dish.setDescription(getText("description", n));
        dish.setPortion(getText("portion", n));
        dish.setPrice(getText("price", n));
        return dish;
    }

    private String getText(String nameTag, Node n) {
        return getTextByTag((Element) n, nameTag);
    }


    private String getTextByTag(Element el, String tagName) {
        NodeList nodeList = el.getElementsByTagName(tagName);
        return nodeList.item(0).getTextContent().trim();
    }
}