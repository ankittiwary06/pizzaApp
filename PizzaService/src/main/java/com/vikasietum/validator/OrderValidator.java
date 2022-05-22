package com.vikasietum.validator;

import com.vikasietum.exception.OrderNotValidException;
import com.vikasietum.model.Order;
import com.vikasietum.model.OrderItem;
import com.vikasietum.model.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class OrderValidator {
    @Value("${pizza.nonveg.topping.not.allowed}")
    private String nonVegToppingNotAllowed;
    public void validate(Order order) throws OrderNotValidException {
        Iterator<OrderItem> it = order.getOrderItems().iterator();
        boolean type;
        while (it.hasNext()) {
            if (!validateOrderItem(it.next())) ;
            throw new OrderNotValidException("order is not valid");
        }
    }

    public String getNonVegToppingNotAllowed() {
        nonVegToppingNotAllowed=this.nonVegToppingNotAllowed;
        return nonVegToppingNotAllowed;
    }

    public void setNonVegToppingNotAllowed(String nonVegToppingNotAllowed) {
        this.nonVegToppingNotAllowed = nonVegToppingNotAllowed;
    }

    public boolean validateOrderItem(OrderItem orderItem) {
        List<String> toppingsNotAllowed = Arrays.asList(nonVegToppingNotAllowed.split(","));
        boolean vegPizza = orderItem.getPizzaRequest().getPizza().isVeg();

        int nonVegTopping = 0;
        for (Topping topping : orderItem.getToppings()) {
            if (vegPizza)
                if (!topping.isVeg())
                    return false;
            else {
                    if (!topping.isVeg())
                        nonVegTopping++;
                    if (nonVegTopping > 1 || toppingsNotAllowed.contains(topping.getName()))
                        return false;


                }
        }
        return false;

    }
}
