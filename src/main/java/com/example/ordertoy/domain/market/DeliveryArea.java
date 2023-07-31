package com.example.ordertoy.domain.market;

public class DeliveryArea {

  private String district;

  private DeliveryArea(String district) {
    this.district = district;
  }

  public static DeliveryArea from(String district) {
    return new DeliveryArea(district);
  }
}
