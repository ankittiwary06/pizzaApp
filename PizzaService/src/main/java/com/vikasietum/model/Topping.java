package com.vikasietum.model;

import java.util.Comparator;

public class Topping {

    String name;
    Double price;
    boolean veg;

    public Topping(Double price, boolean veg) {
        this.price = price;
        this.veg = veg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVeg() {
        return veg;
    }
}




