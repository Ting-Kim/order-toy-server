package com.example.ordertoy.domain.customer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {

    private UUID id;

    private String name;

    private Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Customer from(String name) {
        return new Customer(UUID.randomUUID(), name);
    }
}
