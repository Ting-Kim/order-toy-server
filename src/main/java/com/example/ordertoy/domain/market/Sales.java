package com.example.ordertoy.domain.market;

import java.util.List;
import java.util.stream.Collectors;

public class Sales {

  private List<FoodSale> foodSales;

  private int totalSalesPrice;

  private Sales(List<FoodSale> foodSales, int totalSalesPrice) {
    this.foodSales = foodSales;
    this.totalSalesPrice = totalSalesPrice;
  }

  public static Sales of(List<FoodSale> foodSales, int totalSalesPrice) {
    return new Sales(foodSales, totalSalesPrice);
  }

  public static Sales create(List<Food> foods) {
    return new Sales(foods.stream()
                          .map(FoodSale::create)
                          .collect(Collectors.toList()), 0);
  }
}
