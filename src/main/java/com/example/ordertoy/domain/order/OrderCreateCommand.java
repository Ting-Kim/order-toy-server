package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

@Getter
public class OrderCreateCommand {

  private OrderItems orderItems;

  private Customer customer;

  private DeliveryAddress deliveryAddress;

  private Market market;

  public OrderCreateCommand(OrderItems orderItems, Customer customer,
                            DeliveryAddress deliveryAddress, Market market) {
    this.orderItems = orderItems;
    this.customer = customer;
    this.deliveryAddress = deliveryAddress;
    this.market = market;
  }
}
