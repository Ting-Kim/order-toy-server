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

  private Market market; // TODO: 필요 여부 체크

  public OrderItem(UUID id, Food food, int count) {
    this.id = id;
    this.food = food;
    this.count = count;
  }

  public static OrderItem of(Food food, int count) {
    return new OrderItem(UUID.randomUUID(), food, count);
  }
}
