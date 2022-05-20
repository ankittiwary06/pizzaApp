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

        /*Pizza pizza = new Pizza();
        pizza.setName("Deluxe veggie");
        pizza.setSmallPrice(150.0);
        pizza.setLargePrice(325.0);
        List<Pizza> pizzaList= new ArrayList<>();
        Topping topping=new Topping(25,true);
        topping.setName("Capsicum");
        List<Topping> toppingList=new ArrayList<>();
        toppingList.add(topping);
        SideItem sideItem=new SideItem();
        sideItem.setPrice(55.0);
        sideItem.setName("Cold drink");
        List<SideItem> sideItemList=new ArrayList<>();
        sideItemList.add(sideItem);
        List<Crust> crusts=new ArrayList<Crust>();
        crusts.add(Crust.NEW_HAND_TOSSED);
        crusts.add(Crust.CHEESE_BURST);*/
        Menu menu;
        menuservice.setPizzaFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\pizza.json");
        menuservice.setToppingFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\topping.json");
        menuservice.setSideItemFilePath("C:\\Ankit\\project\\PizzaService\\PizzaService\\src\\test\\resources\\sideitem.json");
        menu = menuservice.getMenu();
        Pizza pizza;
        pizza = menu.getPizzas().get(0);
        //assert menu.getPizzas().get(0).get.equals("Deluxe Veggie");
    }


}


