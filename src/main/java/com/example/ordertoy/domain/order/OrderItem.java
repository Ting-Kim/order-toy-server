package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderItem {

  private UUID id;

  private UUID marketId;

  private Food food;

  private int count;

  private OrderItem(UUID id, UUID marketId, Food food, int count) {
    this.id = id;
    this.food = food;
    this.count = count;
  }

  public static OrderItem of(UUID id, UUID marketId, Food food, int count) {
    return new OrderItem(id, marketId, food, count);
  }

  public static OrderItem create(UUID marketId, Food food, int count) {
    return new OrderItem(UUID.randomUUID(), marketId, food, count);
  }
}
