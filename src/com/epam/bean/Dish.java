package com.epam.bean;

public class Dish {
    private String name="";
    private String description="";
    private String portion="";
    private String price="";

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getPortion(){
        return portion;
    }

    public String getPrice(){
        return price;
    }

    public String toString() {
        return "name: " + name + ", description: " + description + ", portion: " + portion + ", price: " + price;
    }
}
