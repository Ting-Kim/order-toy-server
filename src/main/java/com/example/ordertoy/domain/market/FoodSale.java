package com.example.ordertoy.domain.market;

import lombok.Getter;

@Getter
public class FoodSale {

  private Food food;

  private int salesCount;

  private FoodSale(Food food, int salesCount) {
    this.food = food;
    this.salesCount = salesCount;
  }

  public static FoodSale of(Food food, int salesCount) {
    return new FoodSale(food, salesCount);
  }

  public static FoodSale create(Food food) {
    return new FoodSale(food, 0);
  }

  public Integer calculateTotalPrice() {
    return food.getPrice() * salesCount;
  }
}
