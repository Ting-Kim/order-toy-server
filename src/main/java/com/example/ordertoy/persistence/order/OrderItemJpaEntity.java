package com.example.ordertoy.persistence.order;

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
public class OrderItemJpaEntity {

  @Id
  private UUID id;

  private UUID foodId;

  private Integer count;

  @PrePersist
  public void createId() {
    this.id = UUID.randomUUID();
  }

  public OrderItemJpaEntity(UUID foodId, Integer count) {
    this.foodId = foodId;
    this.count = count;
  }

}
