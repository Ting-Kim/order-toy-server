package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {

    private UUID id;

    private OrderStatus status;

    private OrderItems orderItems;

    private Customer customer;

    private Market market;

    public Order(UUID id, OrderStatus status, OrderItems orderItems, Customer customer, Market market) {
        this.id = id;
        this.status = status;
        this.orderItems = orderItems;
        this.customer = customer;
        this.market = market;
    }

    public static Order create(OrderCreateCommand command) {
        return new Order(
                UUID.randomUUID(),
                OrderStatus.CHECKING,
                command.getOrderItems(),
                command.getCustomer(),
                command.getMarket());
    }
}
