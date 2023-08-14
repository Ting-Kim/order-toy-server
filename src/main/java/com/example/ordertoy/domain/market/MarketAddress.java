package com.example.ordertoy.domain.market;

import com.example.ordertoy.domain.common.Address;
import java.util.UUID;
import lombok.Getter;

@Getter
public class MarketAddress extends Address {

  private UUID marketId;

  private MarketAddress(UUID id, String content, String detail,
                        String zipCode
  ) {
    super(id, content, detail, zipCode);
  }

  public static MarketAddress of(UUID id, String content, String detail, String zipCode) {
    return new MarketAddress(id, content, detail, zipCode);
  }

  public static MarketAddress create(String content, String detail, String zipCode) {
    return new MarketAddress(UUID.randomUUID(), content, detail, zipCode);
  }

  public void updateMarketId(UUID marketId) {
    this.marketId = marketId;
  }
}
