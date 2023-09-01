package com.example.ordertoy.web.order.create.rqrs;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateOrderItemRq {

  private UUID foodId;

  private Integer count;

}
