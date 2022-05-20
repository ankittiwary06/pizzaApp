package com.vikasietum.model;

public class OrderResponse {
    private String orderId;
    private Double orderCost;

    public String getOrderId() {
        return orderId;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    public OrderResponse(String orderId, Double orderCost) {
        this.orderId = orderId;
        this.orderCost = orderCost;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
