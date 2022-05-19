package com.vikasietum.model;

import com.vikasietum.service.MenuService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Pizza> pizzas;
    List<Topping> toppings;
    List<Crust> crusts;
    List<SideItem> sideItems;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Crust> getCrusts() {
        return crusts;
    }

    public void setCrusts(List<Crust> crusts) {
        this.crusts = crusts;
    }

    public List<SideItem> getSideItems() {
        return sideItems;
    }

    public void setSideItems(List<SideItem> sideItems) {
        this.sideItems = sideItems;
    }
}