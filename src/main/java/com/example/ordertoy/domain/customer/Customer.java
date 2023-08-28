package com.example.ordertoy.domain.customer;

import java.util.List;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {

  private UUID id;

  private String name;

  private Membership membership;

  private CustomerAddresses addresses;

  private Customer(UUID id, String name, Membership membership, CustomerAddresses addresses) {
    this.id = id;
    this.name = name;
    this.membership = membership;
    this.addresses = addresses;
  }

  public static Customer of(UUID id, String name, Membership membership, List<CustomerAddress> customerAddresses) {
    return new Customer(id, name, membership, CustomerAddresses.from(customerAddresses));
  }

  public static Customer create(String name) {
    return new Customer(UUID.randomUUID(), name, Membership.create(), CustomerAddresses.from(List.of()));
  }

  public CustomerAddress findAddressById(UUID customerAddressId) {
    return addresses.findById(customerAddressId);
  }
}
