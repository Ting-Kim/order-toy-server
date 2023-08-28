package com.example.ordertoy.domain.customer;

import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class CustomerAddresses {

  private List<CustomerAddress> customerAddresses;

  private CustomerAddresses(List<CustomerAddress> customerAddresses) {
    this.customerAddresses = customerAddresses;
  }

  public static CustomerAddresses from(List<CustomerAddress> customerAddresses) {
    return new CustomerAddresses(customerAddresses);
  }

  public CustomerAddress findById(UUID id) {
    return customerAddresses.stream()
                            .filter(a -> id.equals(a.getId()))
                            .findAny()
                            .orElseThrow(IllegalArgumentException::new);
  }
}
