package com.example.ordertoy.persistence.market;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_delivery_tip_standard")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryTipStandardJpaEntity {

  @Id
  @Column(name = "delivery_tip_standard_id")
  private UUID id;

  @Column(name = "delivery_policy_id")
  private UUID deliveryPolicyId;

  @Column(name = "order_price_more_than")
  private Integer orderPriceMoreThan;

  @Column(name = "order_price_under")
  private Integer orderPriceUnder;

  @Column(name = "delivery_price")
  private Integer deliveryPrice;

  @PrePersist
  public void createId() {
    this.id = UUID.randomUUID();
  }
  private DeliveryTipStandardJpaEntity(
      UUID id, int orderPriceMoreThan, int orderPriceUnder, int deliveryPrice
  ) {
    this.id = id;
    this.orderPriceMoreThan = orderPriceMoreThan;
    this.orderPriceUnder = orderPriceUnder;
    this.deliveryPrice = deliveryPrice;
  }

  public static DeliveryTipStandardJpaEntity of(UUID id, int distanceMoreThan, int distanceUnder, int deliveryPrice) {
    return new DeliveryTipStandardJpaEntity(id, distanceMoreThan, distanceUnder, deliveryPrice);
  }

  public static DeliveryTipStandardJpaEntity create(int minimumOrderPrice) {
    return new DeliveryTipStandardJpaEntity(null, minimumOrderPrice, 9999999, 2000);
  }
}
