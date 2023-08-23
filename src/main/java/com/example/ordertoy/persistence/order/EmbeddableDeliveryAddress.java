package com.example.ordertoy.persistence.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class EmbeddableDeliveryAddress {

  @Column(name = "address")
  private String address;

  @Column(name = "detail_address")
  private String detailAddress;

  @Column(name = "zip_code")
  private String zipCode;

  public EmbeddableDeliveryAddress(String address, String detailAddress, String zipCode) {
    this.address = address;
    this.detailAddress = detailAddress;
    this.zipCode = zipCode;
  }
}
