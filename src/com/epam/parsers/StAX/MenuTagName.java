package com.epam.parsers.StAX;

public enum MenuTagName {
    NAME, DESCRIPTION, PORTION, PRICE, DISH, CATEGORY, MENU;

    public static MenuTagName getElementByTagName(String element) {
        switch (element) {
            case "name":
                return NAME;
            case "description":
                return DESCRIPTION;
            case "portion":
                return PORTION;
            case "price":
                return PRICE;
            case "dish":
                return DISH;
            case "category":
                return CATEGORY;
            case "menu":
                return MENU;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}
