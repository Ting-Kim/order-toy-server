package com.example.ordertoy.domain.market;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Food {

  public static final int INIT_AVERAGE_MINUTE_REQUIRED = 30;

  private UUID id;

  private UUID marketId;

  private String name;

  private int price;

  private int averageMinuteRequired;

  private Food(UUID id, UUID marketId, String name, int price, int averageMinuteRequired) {
    this.id = id;
    this.marketId = marketId;
    this.name = name;
    this.price = price;
    this.averageMinuteRequired = averageMinuteRequired;
  }

  public static Food of(UUID id, UUID marketId, String name, int price, int averageMinuteRequired) {
    return new Food(id, marketId, name, price, averageMinuteRequired);
  }

  public static Food create(UUID marketId, String name, int price, int averageMinuteRequired) {
    return new Food(UUID.randomUUID(), marketId, name, price, averageMinuteRequired);
  }
}
