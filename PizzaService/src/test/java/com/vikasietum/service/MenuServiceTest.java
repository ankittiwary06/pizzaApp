package com.vikasietum.service;

import com.vikasietum.model.Menu;
import com.vikasietum.model.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {
    @InjectMocks
    MenuService menuservice = new MenuService();


    @Test
    public void menuServiceTest() throws IOException {


        Menu menu;
        menuservice.setPizzaFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\pizza.json");
        menuservice.setToppingFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\topping.json");
        menuservice.setSideItemFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\sideitem.json");
        menu = menuservice.getMenu();

        assert menu.getPizzas().get(0).getName().equals("Deluxe Veggie");
        assert menu.getToppings().get(0).isVeg()==true;
    }


}


