package com.example.ordertoy.domain.market;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.order.DeliveryAddress;
import java.util.List;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Market {

  private UUID id;

  private String name;

  private MarketAddress address;

  private Sales sales;

  private DeliveryPolicy deliveryPolicy;

  private BlackCustomers blackCustomers;

  private Market(
      UUID id, String name, MarketAddress address, Sales sales, DeliveryPolicy deliveryPolicy,
      BlackCustomers blackCustomers
  ) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.sales = sales;
    this.deliveryPolicy = deliveryPolicy;
    this.blackCustomers = blackCustomers;
  }

  public static Market of(
      String name, MarketAddress address, Sales sales, DeliveryPolicy deliveryPolicy,
      BlackCustomers blackCustomers
  ) {
    return new Market(UUID.randomUUID(), name, address, sales, deliveryPolicy, blackCustomers);
  }

  public static Market create(
      String name, MarketAddress address, List<Food> foods, int minimumOrderPrice,
      List<DeliveryArea> availableDeliveryAreas, BlackCustomers blackCustomers
  ) {
    UUID id = UUID.randomUUID();
    return new Market(id, name, address, Sales.create(id, foods),
                      DeliveryPolicy.create(id, minimumOrderPrice, availableDeliveryAreas),
                      blackCustomers);
  }

  public void validateIsNotBlackCustomer(Customer customer) {
    if (blackCustomers.contains(customer)) {
      throw new IllegalArgumentException("블랙리스트에 존재하는 고객의 주문은 받을 수 없습니다.");
    }
  }

  public void validateIsAvailableDeliveryAddress(DeliveryAddress deliveryAddress) {
    if (!isInAvailableDeliveryArea(deliveryAddress)) {
      throw new IllegalArgumentException("배달 가능 지역이 아닙니다.");
    }
  }

  private boolean isInAvailableDeliveryArea(DeliveryAddress deliveryAddress) {
    return false; // TODO: 구현 필요
  }
}
