package com.example.ordertoy.domain.market;

import lombok.Getter;

@Getter
public class Food {

    private Long id;

    private String name;

    private int price;

    private int averageMinuteRequired;

    public Food(Long id, String name, int price, int averageMinuteRequired) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.averageMinuteRequired = averageMinuteRequired;
    }
}
