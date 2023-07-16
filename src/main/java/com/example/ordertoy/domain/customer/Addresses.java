package com.example.ordertoy.domain.customer;

import java.util.List;
import lombok.Getter;

@Getter
public class Addresses {

  private List<Address> addresses;

  private Addresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public static Addresses from(List<Address> addresses) {
    return new Addresses(addresses);
  }
}
