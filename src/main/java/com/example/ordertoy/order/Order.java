package com.example.ordertoy.order;

import com.example.ordertoy.customer.Customer;
import com.example.ordertoy.market.Market;
import lombok.Getter;

@Getter
public class Order {

    private Long id;

    private OrderStatus status;

    private OrderItems orderItems;

    private Customer customer;

    private Market market;

    public Order(Long id, OrderStatus status, OrderItems orderItems, Customer customer, Market market) {
        this.id = id;
        this.status = status;
        this.orderItems = orderItems;
        this.customer = customer;
        this.market = market;
    }
}
