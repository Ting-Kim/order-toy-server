package com.example.ordertoy.domain.order;

import lombok.Getter;

@Getter
public class DeliveryAddress {

  private String address;

  private String detailAddress;

  private DeliveryAddress(String address, String detailAddress) {
    this.address = address;
    this.detailAddress = detailAddress;
  }

  public static DeliveryAddress of(String address, String detailAddress) {
    return new DeliveryAddress(address, detailAddress);
  }
}
