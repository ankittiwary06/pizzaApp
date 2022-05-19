package com.vikasietum.repository;

import com.vikasietum.model.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderRepository {
    private Map<String, Order> orders=new HashMap<>();

    public String save(Order order) {
        String id = UUID.randomUUID().toString();
        orders.put(id, order);
        return id;
    }
}
