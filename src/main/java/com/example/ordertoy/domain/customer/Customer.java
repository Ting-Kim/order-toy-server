package com.example.ordertoy.domain.customer;

import lombok.Getter;

@Getter
public class Customer {

    private Long id;

    private String name;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
