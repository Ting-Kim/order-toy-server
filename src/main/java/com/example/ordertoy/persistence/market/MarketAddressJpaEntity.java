package com.example.ordertoy.persistence.market;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_market_address")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketAddressJpaEntity {

  @Id
  @Column(name = "market_address_id")
  private UUID id;

  @Column(name = "market_id")
  private UUID marketId;

  @Column(name = "address")
  private String address;

  @Column(name = "detail_address")
  private String detailAddress;

  @Column(name = "zip_code")
  private String zipCode;

  public MarketAddressJpaEntity(UUID id, UUID marketId, String address, String detailAddress, String zipCode) {
    this.id = id;
    this.marketId = marketId;
    this.address = address;
    this.detailAddress = detailAddress;
    this.zipCode = zipCode;
  }
}
