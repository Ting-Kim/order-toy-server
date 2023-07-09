package com.example.ordertoy.domain.market;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Market {

    private UUID id;

    private String name;

    private String address;

    // TODO: 배송비 정책 (DeliveryPolicy)

    private Market(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Market of(String name, String address) {
        return new Market(UUID.randomUUID(), name, address);
    }
}
