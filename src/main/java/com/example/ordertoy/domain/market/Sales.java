package com.example.ordertoy.domain.market;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Sales {

  private UUID marketId;

  private List<FoodSale> foodSales;

  private int totalSalesPrice;

  private Sales(UUID marketId, List<FoodSale> foodSales, int totalSalesPrice) {
    this.marketId = marketId;
    this.foodSales = foodSales;
    this.totalSalesPrice = totalSalesPrice;
  }

  public static Sales of(UUID marketId, List<FoodSale> foodSales, int totalSalesPrice) {
    return new Sales(marketId, foodSales, totalSalesPrice);
  }

  public static Sales create(UUID marketId, List<Food> foods) {
    return new Sales(marketId, foods.stream()
                                    .map(Food::getId)
                                    .map(FoodSale::create)
                                    .collect(Collectors.toList()), 0);
  }
}
