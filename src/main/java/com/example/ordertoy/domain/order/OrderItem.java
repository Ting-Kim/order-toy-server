package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderItem {

  private UUID id;

  private Food food;

  private int count;

  private Market market;

  private OrderItem(UUID id, Food food, int count, Market market) {
    this.id = id;
    this.food = food;
    this.count = count;
    this.market = market;
  }

  public static OrderItem of(Food food, int count, Market market) {
    return new OrderItem(UUID.randomUUID(), food, count, market);
  }
}
