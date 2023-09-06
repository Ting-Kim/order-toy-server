package com.example.ordertoy.persistence.market.delivery;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_delivery_policy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryPolicyJpaEntity {

  @Id
  @Column(name = "delivery_policy_id")
  private UUID id;

  @Column(name = "market_id")
  private UUID marketId;

  @Column(name = "minimum_order_price")
  private Integer minimumOrderPrice;

  @ElementCollection
  private List<UUID> availableDeliveryAreaIds;
}
