package com.vikasietum.model;

import java.util.List;

public class OrderItem {
    PizzaRequest pizzaRequest;
    List<Topping> toppings;
    List<SideItem> sideItems;

    public PizzaRequest getPizzaRequest() {
        return pizzaRequest;
    }

    public void setPizzaRequest(PizzaRequest pizzaRequest) {
        this.pizzaRequest = pizzaRequest;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<SideItem> getSideItems() {
        return sideItems;
    }

    public void setSideItems(List<SideItem> sideItems) {
        this.sideItems = sideItems;
    }
}
