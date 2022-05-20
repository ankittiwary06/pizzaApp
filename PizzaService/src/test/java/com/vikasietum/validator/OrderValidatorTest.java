package com.vikasietum.validator;

import com.vikasietum.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderValidatorTest {
    @InjectMocks
    OrderValidator orderValidator = new OrderValidator();
    @Mock
    Order order;


    @Test
    public void validateSuccess() throws Exception {
        Pizza pizza = new Pizza();
        pizza.setName("Deluxe Veggie");
        pizza.setVeg(true);
        PizzaRequest pizzaRequest = new PizzaRequest();
        pizzaRequest.setPizza(pizza);
        pizzaRequest.setCrust("Cheese burst");
        SideItem sideItem = new SideItem();
        sideItem.setName("Cold drink");
        List<SideItem> sideItemsList = new ArrayList<>();
        sideItemsList.add(sideItem);
        Topping topping = new Topping(20.0, true);
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(topping);

        OrderItem orderItem = new OrderItem();
        orderItem.setSideItems(sideItemsList);
        orderItem.setToppings(toppingList);
        orderItem.setPizzaRequest(pizzaRequest);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        orderValidator.setNonVegToppingNotAllowed("Paneer");
        orderValidator.validateOrderItem(orderItem);


    }


    @Test(expected = Exception.class)
    public void validateException() throws Exception {
        Pizza pizza = new Pizza();
        pizza.setName("Deluxe Veggie");
        pizza.setVeg(true);
        PizzaRequest pizzaRequest = new PizzaRequest();
        pizzaRequest.setPizza(pizza);
        pizzaRequest.setCrust("Cheese burst");
        SideItem sideItem = new SideItem();
        sideItem.setName("Cold drink");
        List<SideItem> sideItemsList = new ArrayList<>();
        sideItemsList.add(sideItem);
        Topping topping = new Topping(20.0, false);
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(topping);

        OrderItem orderItem = new OrderItem();
        orderItem.setSideItems(sideItemsList);
        orderItem.setToppings(toppingList);
        orderItem.setPizzaRequest(pizzaRequest);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        orderValidator.validateOrderItem(orderItem);


    }
}

