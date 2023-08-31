package com.example.ordertoy.persistence.order;

import com.example.ordertoy.domain.order.Order;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderAdapter {

  private final OrderMapper orderMapper;
  private final OrderJpaRepository orderJpaRepository;

  public void save(Order order) {
    orderJpaRepository.save(orderMapper.mapToJpaEntity(order));
  }
}
