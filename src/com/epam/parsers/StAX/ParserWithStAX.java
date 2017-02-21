package com.epam.parsers.StAX;

import com.epam.bean.Dish;
import com.epam.bean.Menu;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParserWithStAX {


    public void readXMLFile(String url, String type) throws XMLStreamException, FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        InputStream input = new FileInputStream(url);
        XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

        Menu menu = process(reader);
        System.out.println(menu.showCategory(type));

    }

    private static Menu process(XMLStreamReader reader) throws XMLStreamException {

        Dish dish = null;
        Menu menu = null;
        ArrayList<Dish> dishArrayList = null;
        MenuTagName elementName = null;
        String category = null;
        while (reader.hasNext()) {
            int constant = reader.next();
            switch (constant) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementByTagName(reader.getLocalName());
                    switch (elementName) {
                        case CATEGORY:
                            menu = new Menu();
                            dishArrayList = new ArrayList<>();
                            category = reader.getAttributeValue(null, "name");
                            break;
                        case DISH:
                            dish = new Dish();
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            dish.setName(text);
                            break;
                        case DESCRIPTION:
                            dish.setDescription(text);
                            break;
                        case PORTION:
                            dish.setPortion(text);
                            break;
                        case PRICE:
                            dish.setPrice(text);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementByTagName(reader.getLocalName());
                    switch (elementName){
                        case DISH:
                            dishArrayList.add(dish);
                        case CATEGORY:
                            menu.addCategory(category,dishArrayList);
                    }

            }
        }
        return menu;
    }
}
