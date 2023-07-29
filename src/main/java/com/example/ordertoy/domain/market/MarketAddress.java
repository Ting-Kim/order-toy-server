package com.example.ordertoy.domain.market;

import com.example.ordertoy.domain.common.Address;
import java.util.UUID;
import lombok.Getter;

@Getter
public class MarketAddress extends Address {

  private UUID marketId;

  private MarketAddress(UUID id, UUID marketId, String name, String content, String detail,
                        ZipCode zipCode
  ) {
    super(id, name, content, detail, zipCode);
    this.marketId = marketId;
  }

  public static MarketAddress of(UUID id, UUID marketId, String name, String content, String detail, ZipCode zipCode) {
    return new MarketAddress(id, marketId, name, content, detail, zipCode);
  }

  public static MarketAddress create(UUID marketId, String name, String content, String detail, ZipCode zipCode) {
    return new MarketAddress(UUID.randomUUID(), marketId, name, content, detail, zipCode);
  }
}
