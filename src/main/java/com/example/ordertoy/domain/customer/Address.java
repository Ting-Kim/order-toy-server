package com.example.ordertoy.domain.customer;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Address {

  private UUID id;

  private UUID customerId;

  private String name;

  private String content;

  private String detail;

  private Address(UUID id, UUID customerId, String name, String content, String detail) {
    this.id = id;
    this.customerId = customerId;
    this.name = name;
    this.content = content;
    this.detail = detail;
  }

  public static Address of(UUID id, UUID customerId, String name, String content, String detail) {
    return new Address(id, customerId, name, content, detail);
  }

  public static Address create(UUID customerId, String name, String content, String detail) {
    return new Address(UUID.randomUUID(), customerId, name, content, detail);
  }
}
