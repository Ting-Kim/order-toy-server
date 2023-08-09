package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.Food;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderItems {

  List<OrderItem> orderItems;

  private OrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public static OrderItems from(List<OrderItem> orderItems) {
    validate(orderItems);
    return new OrderItems(orderItems);
  }

  private static void validate(List<OrderItem> orderItems) {
    long marketsCount = orderItems.stream()
                                  .map(OrderItem::getFood)
                                  .map(Food::getMarketId)
                                  .distinct()
                                  .count();
    if (marketsCount > 1) {
      throw new IllegalArgumentException("한 가게의 메뉴만 담을 수 있습니다."); // TODO: 내부 Exeception 수립 후 교체
    }
  }
}
