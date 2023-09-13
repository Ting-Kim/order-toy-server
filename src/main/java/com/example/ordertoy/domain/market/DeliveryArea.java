package com.example.ordertoy.domain.market;

import java.util.UUID;
import lombok.Getter;

@Getter
public class DeliveryArea {

  private UUID id;
  private String district;

  private DeliveryArea(UUID id, String district) {
    this.id = id;
    this.district = district;
  }

  public static DeliveryArea of(UUID id, String district) {
    return new DeliveryArea(id, district);
  }
}
