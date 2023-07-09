package com.example.ordertoy.order;

import com.example.ordertoy.market.Food;
import lombok.Getter;

@Getter
public class OrderItem {

    private Long id;

    private Food food;

    private int count;

    public OrderItem(Long id, Food food, int count) {
        this.id = id;
        this.food = food;
        this.count = count;
    }
}
