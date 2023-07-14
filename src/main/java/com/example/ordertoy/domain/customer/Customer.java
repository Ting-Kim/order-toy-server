package com.example.ordertoy.domain.customer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {

    private UUID id;

    private String name;

    private Membership membership;

    private Customer(UUID id, String name, Membership membership) {
        this.id = id;
        this.name = name;
        this.membership = membership;
    }

    public static Customer of(String name, Membership membership) {
        return new Customer(UUID.randomUUID(), name, membership);
    }

    public static Customer create(String name) {
        return new Customer(UUID.randomUUID(), name, Membership.create());
    }
}
