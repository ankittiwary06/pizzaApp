package com.vikasietum.service;

import com.vikasietum.exception.OrderNotValidException;
import com.vikasietum.model.*;
import com.vikasietum.repository.OrderRepository;
import com.vikasietum.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OrderService {
    @Autowired
    OrderValidator orderValidator;
    @Autowired
    OrderRepository orderRepository;

    public OrderResponse createOrder(Order order) throws OrderNotValidException {

        orderValidator.validate(order);

        String orderId = orderRepository.save(order);
        OrderResponse orderResponse = new OrderResponse(orderId, getOrderCost(order));
        return orderResponse;
    }

    public Double getOrderCost(Order order) {
        Double cost = 0.0;
        List<OrderItem> items = order.getOrderItems();
        for (OrderItem item : items) {
            if ((item.getPizzaRequest().getPizza().getSize().toLowerCase()).equals("small"))   // adding cost for small pizza
                cost = item.getPizzaRequest().getPizza().getSmallPrice() + cost;
            else if ((item.getPizzaRequest().getPizza().getSize().toLowerCase()).equals("medium"))
                cost = item.getPizzaRequest().getPizza().getMediumPrice() + cost;
            else
                cost = item.getPizzaRequest().getPizza().getLargePrice() + cost;

            /*if(null != item.getToppings() && item.getPizzaRequest().getPizza().getSize().toLowerCase()).equals("large"))
            {

            }*/


            if (null != item.getToppings()) {
                if ((item.getPizzaRequest().getPizza().getSize().toLowerCase()).equals("large")) {
                    Collections.sort(item.getToppings(), new SortByPrice());
                    Collections.reverse(item.getToppings());
                    int i = 0;
                    for (Topping topping : item.getToppings()) {
                        if (i >= 2) {
                            cost =(Double)topping.getPrice() + cost;
                        }
                        i++;
                    }


                } else {
                    for (Topping topping : item.getToppings()) {
                        cost = topping.getPrice() + cost;
                    }
                }
            }
            if (null != item.getSideItems()) {
                for (SideItem sideitem : item.getSideItems()) {
                    cost = sideitem.getPrice() + cost;

                }
            }
        }

        return cost;
    }


}
