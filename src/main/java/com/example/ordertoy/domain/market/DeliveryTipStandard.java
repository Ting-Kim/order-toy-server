package com.example.ordertoy.domain.market;

import lombok.Getter;

@Getter
public class DeliveryTipStandard {

  private int orderPriceMoreThan;

  private int orderPriceUnder;

  private int deliveryPrice;

  private DeliveryTipStandard(int orderPriceMoreThan, int orderPriceUnder, int deliveryPrice) {
    this.orderPriceMoreThan = orderPriceMoreThan;
    this.orderPriceUnder = orderPriceUnder;
    this.deliveryPrice = deliveryPrice;
  }

  public static DeliveryTipStandard of(int orderPriceMoreThan, int orderPriceUnder, int deliveryPrice) {
    return new DeliveryTipStandard(orderPriceMoreThan, orderPriceUnder, deliveryPrice);
  }

  public static DeliveryTipStandard createDefault(int minimumOrderPrice) {
    return new DeliveryTipStandard(minimumOrderPrice, 9999999, 2000);
  }
}
