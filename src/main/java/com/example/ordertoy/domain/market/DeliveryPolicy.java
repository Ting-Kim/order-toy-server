package com.example.ordertoy.domain.market;

import java.util.List;
import lombok.Getter;

@Getter
public class DeliveryPolicy {

  private int minimumOrderPrice;

  private List<DeliveryTipStandard> deliveryTipStandards;

  private List<DeliveryArea> availableDeliveryAreas;

  private DeliveryPolicy(
      int minimumOrderPrice, List<DeliveryTipStandard> deliveryTipStandards,
      List<DeliveryArea> availableDeliveryAreas
  ) {
    this.minimumOrderPrice = minimumOrderPrice;
    this.deliveryTipStandards = deliveryTipStandards;
    this.availableDeliveryAreas = availableDeliveryAreas;
  }

  public static DeliveryPolicy of(int minimumOrderPrice, List<DeliveryArea> deliveryAreas) {
    return new DeliveryPolicy(minimumOrderPrice,
                              List.of(DeliveryTipStandard.createDefault(minimumOrderPrice)),
                              deliveryAreas);
  }

  public static DeliveryPolicy of(
      int minimumOrderPrice,
      List<DeliveryTipStandard> deliveryTipStandards, List<DeliveryArea> deliveryAreas
  ) {
    return new DeliveryPolicy(minimumOrderPrice, deliveryTipStandards, deliveryAreas);
  }
}
