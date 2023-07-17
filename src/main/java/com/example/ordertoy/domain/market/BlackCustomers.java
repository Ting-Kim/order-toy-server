package com.example.ordertoy.domain.market;

import com.example.ordertoy.domain.customer.Customer;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class BlackCustomers {

  private List<UUID> ids;

  private BlackCustomers(List<UUID> ids) {
    this.ids = ids;
  }

  public static BlackCustomers from(List<UUID> ids) {
    return new BlackCustomers(ids);
  }

  public boolean contains(Customer customer) {
    return ids.contains(customer.getId());
  }
}
