package com.example.ordertoy.market;

import lombok.Getter;

@Getter
public class Market {

    private Long id;

    private String name;

    private String address;

    public Market(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
