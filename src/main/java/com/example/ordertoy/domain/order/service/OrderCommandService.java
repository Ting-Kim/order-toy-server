package com.example.ordertoy.domain.order.service;

import com.example.ordertoy.domain.order.Order;
import com.example.ordertoy.domain.order.OrderCreateCommand;
import com.example.ordertoy.domain.order.OrderValidateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCommandService {

  public Order createOrder(OrderCreateCommand command) {
    return Order.create(command.getOrderItems(),
                        command.getCustomer(),
                        command.getDeliveryAddress(),
                        command.getMarket());
  }

  public Order validateOrder(OrderValidateCommand command) {
    Order order = command.getOrder();

    order.validate();

    return order;
  }
}
