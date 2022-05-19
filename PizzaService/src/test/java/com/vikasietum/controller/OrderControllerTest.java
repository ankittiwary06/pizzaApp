package com.vikasietum.controller;

import com.vikasietum.model.*;
import com.vikasietum.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @InjectMocks
    OrderController orderController= new OrderController();

    @Mock
    OrderService orderService;


    @Test
    public void createOrderTest() {

        Order order = new Order();

        OrderResponse orderResponse = new OrderResponse("sdgag", 150.0);
        orderResponse.setOrderId("sdgag");
        orderResponse.setOrderCost(150.0);

        Mockito.when(orderService.createOrder(order)).thenReturn(orderResponse);

        ResponseEntity<OrderResponse> responseEntity = orderController.createOrder(order);
        OrderResponse entityOrderResponse = responseEntity.getBody();
        assert entityOrderResponse.getOrderCost() == orderResponse.getOrderCost();
        assert entityOrderResponse.getOrderId() == orderResponse.getOrderId();
    }
}
