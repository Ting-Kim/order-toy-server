package com.example.ordertoy.persistence.order;

import com.example.ordertoy.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

  public OrderJpaEntity mapToJpaEntity(Order order) {
    return new OrderJpaEntity(order.getId(),
                              order.getStatus(),
                              order.getCustomerId(),
                              new EmbeddableDeliveryAddress(order.getDeliveryAddress().getAddress(),
                                                            order.getDeliveryAddress().getDetailAddress(),
                                                            order.getDeliveryAddress().getZipCodeValue()),
                              order.getMarketId());
  }

}
