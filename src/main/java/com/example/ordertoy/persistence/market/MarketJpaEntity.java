package com.example.ordertoy.persistence.market;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketJpaEntity {

  @Id
  @Column(name = "market_id")
  private UUID id;

  @Column(name = "market_name")
  private String name;

  @Embedded
  private EmbeddableMarketAddress address;

  @ElementCollection
  private List<UUID> blackCustomerIds;

  private MarketJpaEntity(
      UUID id, String name, EmbeddableMarketAddress address, List<UUID> blackCustomerIds
  ) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.blackCustomerIds = blackCustomerIds;
  }

  public static MarketJpaEntity of(
      UUID id,
      String name,
      EmbeddableMarketAddress address,
      List<UUID> blackCustomerIds
  ) {
    return new MarketJpaEntity(id, name, address, blackCustomerIds);
  }

  public static MarketJpaEntity create(
      String name,
      EmbeddableMarketAddress address,
      List<UUID> blackCustomerIds
  ) {
    return new MarketJpaEntity(UUID.randomUUID(), name, address, blackCustomerIds);
  }
}
