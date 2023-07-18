package com.example.ordertoy.domain.customer;

import java.util.List;
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
}
