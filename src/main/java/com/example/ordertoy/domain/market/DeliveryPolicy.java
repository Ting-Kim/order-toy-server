package com.example.ordertoy.domain.market;

import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class DeliveryPolicy {

  private UUID id;

  private UUID marketId;

  private int minimumOrderPrice;

  private List<DeliveryTipStandard> deliveryTipStandards;

  private List<DeliveryArea> availableDeliveryAreas;

  private DeliveryPolicy(
      UUID id, UUID marketId, int minimumOrderPrice, List<DeliveryTipStandard> deliveryTipStandards,
      List<DeliveryArea> availableDeliveryAreas
  ) {
    this.id = id;
    this.marketId = marketId;
    this.minimumOrderPrice = minimumOrderPrice;
    this.deliveryTipStandards = deliveryTipStandards;
    this.availableDeliveryAreas = availableDeliveryAreas;
  }

  public static DeliveryPolicy of(
      UUID id, UUID marketId, int minimumOrderPrice, List<DeliveryArea> deliveryAreas
  ) {
    return new DeliveryPolicy(id, marketId, minimumOrderPrice,
                              List.of(DeliveryTipStandard.createDefault(minimumOrderPrice)),
                              deliveryAreas);
  }

  public static DeliveryPolicy of(
      UUID id, UUID marketId, int minimumOrderPrice, List<DeliveryTipStandard> deliveryTipStandards,
      List<DeliveryArea> deliveryAreas
  ) {
    return new DeliveryPolicy(id, marketId, minimumOrderPrice, deliveryTipStandards, deliveryAreas);
  }

  public static DeliveryPolicy create(
      UUID marketId, int minimumOrderPrice, List<DeliveryTipStandard> deliveryTipStandards,
      List<DeliveryArea> deliveryAreas
  ) {
    return new DeliveryPolicy(UUID.randomUUID(), marketId, minimumOrderPrice, deliveryTipStandards,
                              deliveryAreas);
  }

  public static DeliveryPolicy create(
      UUID marketId, int minimumOrderPrice, List<DeliveryArea> deliveryAreas
  ) {
    return new DeliveryPolicy(UUID.randomUUID(), marketId, minimumOrderPrice,
                              List.of(DeliveryTipStandard.createDefault(minimumOrderPrice)),
                              deliveryAreas);
  }
}
