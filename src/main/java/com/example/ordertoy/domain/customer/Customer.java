package com.example.ordertoy.domain.customer;

import java.util.List;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Customer {

  private UUID id;

  private String name;

  private Membership membership;

  private Addresses addresses;

  private Customer(UUID id, String name, Membership membership, Addresses addresses) {
    this.id = id;
    this.name = name;
    this.membership = membership;
    this.addresses = addresses;
  }

  public static Customer of(String name, Membership membership, List<Address> addresses) {
    return new Customer(UUID.randomUUID(), name, membership, Addresses.from(addresses));
  }

  public static Customer create(String name) {
    return new Customer(UUID.randomUUID(), name, Membership.create(), Addresses.from(List.of()));
  }
}
