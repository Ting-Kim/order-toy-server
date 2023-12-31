package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.market.Market;
import com.example.ordertoy.domain.order.event.OrderCreatedEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {

    private UUID id;

    private OrderStatus status;

    private OrderItems orderItems;

    private Customer customer;

    private DeliveryAddress deliveryAddress;

    private Market market;

    private Order(UUID id, OrderStatus status, OrderItems orderItems, Customer customer, DeliveryAddress deliveryAddress, Market market) {
        this.id = id;
        this.status = status;
        this.orderItems = orderItems;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.market = market;
    }

    public static Order of(UUID id, OrderStatus status, OrderItems orderItems, Customer customer, DeliveryAddress deliveryAddress, Market market) {
        return new Order(id, status, orderItems, customer, deliveryAddress, market);
    }

    public static OrderCreatedEvent create(OrderItems orderItems, Customer customer, DeliveryAddress deliveryAddress, Market market) {
        return new OrderCreatedEvent(new Order(UUID.randomUUID(), OrderStatus.CHECKING, orderItems, customer, deliveryAddress, market));
    }

    public void validate() {
        // 도메인 서비스에서 고객 주소 검증
        market.validateIsNotBlackCustomer(customer);
        market.validateIsAvailableDeliveryAddress(deliveryAddress);
        this.status = OrderStatus.VALIDATED;
    }

    public UUID getCustomerId() {
        return customer.getId();
    }

    public UUID getMarketId() {
        return market.getId();
    }
}
