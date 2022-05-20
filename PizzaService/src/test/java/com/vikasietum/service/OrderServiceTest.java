package com.vikasietum.service;

import com.vikasietum.model.*;
import com.vikasietum.repository.OrderRepository;
import com.vikasietum.validator.OrderValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @InjectMocks
    OrderService orderService = new OrderService();
    @Mock
    OrderValidator orderValidator;
    @Mock
    OrderRepository orderRepository;

    @Test
    public void createOrderTest() throws Exception {
        Double orderCost = 0.0;


        Pizza pizza = new Pizza();
        pizza.setName("Deluxe Veggie");
        pizza.setSize("large");

        pizza.setLargePrice(150.0);
        PizzaRequest pizzaRequest = new PizzaRequest();
        pizzaRequest.setPizza(pizza);
        Topping topping1=new Topping(30.0,true);
        Topping topping2=new Topping(25.0,true);
        Topping topping3=new Topping(35.0,true);
        List<Topping> toppingList=new ArrayList<>();
        toppingList.add(topping1);
        toppingList.add(topping2);
        toppingList.add(topping3);
        SideItem sideItem = new SideItem();
        sideItem.setName("Cold drink");

        Double sideItemCost = 100.0;
        sideItem.setPrice(sideItemCost);
        List<SideItem> sideItemsList = new ArrayList<>();
        sideItemsList.add(sideItem);
        OrderItem orderItem = new OrderItem();
        orderItem.setPizzaRequest(pizzaRequest);
        orderItem.setSideItems(sideItemsList);
        orderItem.setToppings(toppingList);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);


        Order order = new Order();
        order.setOrderItems(orderItemList);
        orderCost = 150.0 + 100.0+25.0;

        Mockito.when(orderRepository.save(order)).thenReturn("orderid");
        OrderResponse orderResponse = orderService.createOrder(order);


        assert orderResponse.getOrderId().equals("orderid");
        assert Objects.equals(orderResponse.getOrderCost(), orderCost);


    }


}
