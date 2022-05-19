package com.vikasietum.model;

import com.vikasietum.model.Crust;
import com.vikasietum.model.Pizza;

public class PizzaRequest {
    Pizza pizza;
    String crust;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }
}
