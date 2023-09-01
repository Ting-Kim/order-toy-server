package com.example.ordertoy.web.order.create.rqrs;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderCreateRs {

  private UUID orderId;

  public OrderCreateRs(UUID orderId) {
    this.orderId = orderId;
  }
}
