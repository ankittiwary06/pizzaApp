package com.vikasietum.model;

public class Topping {

    String name;
    int price;
    boolean veg;

    public Topping(int price, boolean veg) {
        this.price = price;
        this.veg = veg;
    }

    public int getPrice() {
        return price;
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
