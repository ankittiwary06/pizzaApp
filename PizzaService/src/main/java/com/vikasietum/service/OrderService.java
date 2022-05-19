package com.vikasietum.service;

import com.vikasietum.exception.OrderNotValidException;
import com.vikasietum.model.*;
import com.vikasietum.repository.OrderRepository;
import com.vikasietum.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    @Autowired
    OrderValidator orderValidator;
    @Autowired
    OrderRepository orderRepository;

    public OrderResponse createOrder(Order order) {
        try {
            orderValidator.validate(order);
        } catch (OrderNotValidException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

            if (null != item.getToppings()) {
                for (Topping topping : item.getToppings()) {
                    cost = topping.getPrice() + cost;
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
