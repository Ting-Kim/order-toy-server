package com.example.ordertoy.persistence.market;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_delivery_area")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryAreaJpaEntity {

  @Id
  @Column(name = "delivery_area_id")
  private UUID id;

  @Column(name = "district")
  private String district;

  private DeliveryAreaJpaEntity(UUID id, String district) {
    this.id = id;
    this.district = district;
  }

  public static DeliveryAreaJpaEntity of(UUID id, String district) {
    return new DeliveryAreaJpaEntity(id, district);
  }
}
