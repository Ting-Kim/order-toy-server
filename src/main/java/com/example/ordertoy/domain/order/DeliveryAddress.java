package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.ZipCode;
import lombok.Getter;

@Getter
public class DeliveryAddress {

  private String address;

  private String detailAddress;

  private ZipCode zipCode;

  private DeliveryAddress(String address, String detailAddress, ZipCode zipCode) {
    this.address = address;
    this.detailAddress = detailAddress;
    this.zipCode = zipCode;
  }

  public static DeliveryAddress of(String address, String detailAddress, ZipCode zipCode) {
    return new DeliveryAddress(address, detailAddress, zipCode);
  }
}
