package com.epam.parsers.SAX;


import com.epam.bean.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MenuSAXHandler extends DefaultHandler {
    private Menu menu = new Menu();
    private StringBuilder text;
    private Dish dish;
    private ArrayList<Dish> dishArrayList = new ArrayList<>();
    private String category;

    public String getDishArrayList(String type) {
        return menu.showCategory(type);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        text = new StringBuilder();
        if (qName.equals("category")) {
            category = attributes.getValue("name");
            dishArrayList=new ArrayList<>();
        }
        if (qName.equals("dish")) {
            dish = new Dish();
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) {
        MenuTagName menuTagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (menuTagName) {
            case NAME:
                dish.setName(text.toString());
                break;
            case DESCRIPTION:
                dish.setDescription(text.toString());
                break;
            case PORTION:
                dish.setPortion(text.toString());
                break;
            case PRICE:
                dish.setPrice(text.toString());
                break;
            case DISH:
                dishArrayList.add(dish);
                dish = null;
                break;
            case CATEGORY:
                menu.addCategory(category, dishArrayList);
                category = null;
                dishArrayList = null;
                break;
        }
    }

}
