package com.example.ordertoy.order;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderItems {

    List<OrderItem> orderItems;

    public OrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
