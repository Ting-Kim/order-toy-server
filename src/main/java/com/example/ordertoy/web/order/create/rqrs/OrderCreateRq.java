package com.example.ordertoy.web.order.create.rqrs;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRq {

  private UUID marketId;

  private List<OrderCreateOrderItemRq> orderItems;

  private UUID customerId;

  private UUID customerAddressId;

}
