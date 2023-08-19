package com.example.ordertoy.domain.order.event;

import com.example.ordertoy.domain.order.Order;

public class OrderCreatedEvent implements OrderDomainEvent {

  private Order order;

  public OrderCreatedEvent(Order order) {
    this.order = order;
  }

  @Override
  public Order getSource() {
    return order;
  }
}
