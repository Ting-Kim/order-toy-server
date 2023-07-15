package com.example.ordertoy.domain.market;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Food {

  private UUID id;

  private String name;

  private int price;

  private int averageMinuteRequired;

  private Food(UUID id, String name, int price, int averageMinuteRequired) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.averageMinuteRequired = averageMinuteRequired;
  }

  public static Food of(String name, int price, int averageMinuteRequired) {
    return new Food(UUID.randomUUID(), name, price, averageMinuteRequired);
  }
}
