package com.example.ordertoy.persistence.order;

import com.example.ordertoy.domain.order.DeliveryAddress;
import com.example.ordertoy.domain.order.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderJpaEntity {

  @Id
  @Column(name = "order_id")
  private UUID id;

  @Column(name = "order_status")
  private OrderStatus status;

  @Column(name = "customer_id")
  private UUID customerId;

  @Embedded
  @Column(name = "delivery_address")
  private DeliveryAddress deliveryAddress;

  @Column(name = "market_id")
  private UUID marketId;

  @PrePersist
  public void createId() {
    this.id = UUID.randomUUID();
  }

  public OrderJpaEntity(
      OrderStatus status, UUID customerId, DeliveryAddress deliveryAddress, UUID marketId
  ) {
    this.status = status;
    this.customerId = customerId;
    this.deliveryAddress = deliveryAddress;
    this.marketId = marketId;
  }
}
