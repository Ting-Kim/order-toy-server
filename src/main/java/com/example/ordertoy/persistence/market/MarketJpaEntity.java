package com.example.ordertoy.persistence.market;

import com.example.ordertoy.config.converter.UUIDArrayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_market")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketJpaEntity {

  @Id
  @Column(name = "market_id")
  private UUID id;

  @Column(name = "market_name")
  private String name;

  @Convert(converter = UUIDArrayConverter.class)
  private List<UUID> blackCustomerIds;

  private MarketJpaEntity(
      UUID id, String name, List<UUID> blackCustomerIds
  ) {
    this.id = id;
    this.name = name;
    this.blackCustomerIds = blackCustomerIds;
  }

  public static MarketJpaEntity of(
      UUID id,
      String name,
      List<UUID> blackCustomerIds
  ) {
    return new MarketJpaEntity(id, name, blackCustomerIds);
  }

  public static MarketJpaEntity create(
      String name,
      List<UUID> blackCustomerIds
  ) {
    return new MarketJpaEntity(UUID.randomUUID(), name, blackCustomerIds);
  }
}
