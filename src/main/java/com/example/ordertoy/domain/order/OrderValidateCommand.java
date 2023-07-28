package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.order.Order;
import lombok.Getter;

@Getter
public class OrderValidateCommand {

    private Order order;

    public OrderValidateCommand(Order order) {
        this.order = order;
    }
}
