package com.example.ordertoy.domain.market;

import java.util.List;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Market {

  private UUID id;

  private String name;

  private String address;

  private Sales sales;

  private DeliveryPolicy deliveryPolicy;

  private Market(UUID id, String name, String address, Sales sales, DeliveryPolicy deliveryPolicy) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.sales = sales;
    this.deliveryPolicy = deliveryPolicy;
  }

  public static Market of(String name, String address, Sales sales, DeliveryPolicy deliveryPolicy) {
    return new Market(UUID.randomUUID(), name, address, sales, deliveryPolicy);
  }

  public static Market create(
      String name, String address, List<Food> foods, int minimumOrderPrice,
      List<DeliveryArea> availableDeliverryAreas
  ) {
    UUID id = UUID.randomUUID();
    return new Market(id, name, address, Sales.create(id, foods),
                      DeliveryPolicy.create(id, minimumOrderPrice, availableDeliverryAreas));
  }
}
