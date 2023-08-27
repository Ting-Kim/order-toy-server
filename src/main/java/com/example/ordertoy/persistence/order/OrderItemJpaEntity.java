package com.example.ordertoy.persistence.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_order_item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItemJpaEntity {

  @Id
  private UUID id;

  private UUID marketId;

  private UUID foodId;

  private Integer count;

  @PrePersist
  public void createId() {
    this.id = UUID.randomUUID();
  }

  public OrderItemJpaEntity(UUID marketId, UUID foodId, Integer count) {
    this.marketId = marketId;
    this.foodId = foodId;
    this.count = count;
  }

}
