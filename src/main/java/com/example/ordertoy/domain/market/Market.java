package com.example.ordertoy.domain.market;

import java.util.List;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Market {

    private UUID id;

    private String name;

    private String address;

    private Sales sales;

    // TODO: 배송비 정책 (DeliveryPolicy)

    private Market(UUID id, String name, String address, Sales sales) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sales = sales;
    }

    public static Market of(String name, String address, Sales sales) {
        return new Market(UUID.randomUUID(), name, address, sales);
    }

    public static Market create(String name, String address, List<Food> foods) {
        return new Market(UUID.randomUUID(), name, address, Sales.create(foods));
    }
}
