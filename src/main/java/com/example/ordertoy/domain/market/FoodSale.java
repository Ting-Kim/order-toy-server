package com.example.ordertoy.domain.market;

import java.util.UUID;
import lombok.Getter;

@Getter
public class FoodSale {

  private UUID foodId;

  private int salesCount;

  private FoodSale(UUID foodId, int salesCount) {
    this.foodId = foodId;
    this.salesCount = salesCount;
  }

  public static FoodSale of(UUID foodId, int salesCount) {
    return new FoodSale(foodId, salesCount);
  }

  public static FoodSale create(UUID foodId) {
    return new FoodSale(foodId, 0);
  }
}
