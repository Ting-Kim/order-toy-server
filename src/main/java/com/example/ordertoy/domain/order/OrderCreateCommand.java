package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

@Getter
public class OrderCreateCommand {

  OrderItems orderItems;

  Customer customer;

  Market market;

  public OrderCreateCommand(OrderItems orderItems, Customer customer, Market market) {
    this.orderItems = orderItems;
    this.customer = customer;
    this.market = market;
  }
}
