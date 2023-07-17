package com.example.ordertoy.domain.customer;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Address { // TODO: Customer / Market 도메인 사이 위치 고민 필요

  private UUID id;

  private UUID customerId;

  private String name;

  private String content;

  private String detail;

  private ZipCode zipCode;

  private Address(UUID id, UUID customerId, String name, String content, String detail,
                  ZipCode zipCode
  ) {
    this.id = id;
    this.customerId = customerId;
    this.name = name;
    this.content = content;
    this.detail = detail;
    this.zipCode = zipCode;
  }

  public static Address of(UUID id, UUID customerId, String name, String content, String detail, ZipCode zipCode) {
    return new Address(id, customerId, name, content, detail, zipCode);
  }

  public static Address create(UUID customerId, String name, String content, String detail, ZipCode zipCode) {
    return new Address(UUID.randomUUID(), customerId, name, content, detail, zipCode);
  }
}
