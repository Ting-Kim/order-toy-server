package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

@Getter
public class OrderItem {

    private Long id;

    private Food food;

    private int count;

    private Market market;

    public OrderItem(Long id, Food food, int count, Market market) {
        this.id = id;
        this.food = food;
        this.count = count;
        this.market = market;
    }
}
