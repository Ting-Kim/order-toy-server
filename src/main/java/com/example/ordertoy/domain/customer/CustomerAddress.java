package com.example.ordertoy.domain.customer;

import com.example.ordertoy.domain.common.Address;
import java.util.UUID;
import lombok.Getter;

@Getter
public class CustomerAddress extends Address {

  private String name;
  private UUID customerId;

  private CustomerAddress(UUID id, UUID customerId, String name, String content, String detail,
                          String zipCode
  ) {
    super(id, content, detail, zipCode);
    this.name = name;
    this.customerId = customerId;
  }

  public static CustomerAddress of(UUID id, UUID customerId, String name, String content, String detail, String zipCode) {
    return new CustomerAddress(id, customerId, name, content, detail, zipCode);
  }

  public static CustomerAddress create(UUID customerId, String name, String content, String detail, String zipCode) {
    return new CustomerAddress(UUID.randomUUID(), customerId, name, content, detail, zipCode);
  }
}
