package com.epam.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private HashMap<String, ArrayList<Dish>> menuMap = new HashMap<>();

    public void addCategory(String category, ArrayList<Dish> dishArrayList){
        menuMap.put(category,dishArrayList);
    }

    public String showCategory(String category) {
        String result="";
        for (String s : menuMap.keySet()) {
            if (s.equals(category)) {
                result = showDishes(menuMap.get(category));
                break;
            }
        }
        return result;
    }

    private String showDishes(ArrayList<Dish> dishArrayList) {
        String result = "";
        for (Dish d : dishArrayList) {
            result += d.toString()+"\n";
        }
        return result;
    }
}
