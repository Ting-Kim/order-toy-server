package com.example.ordertoy.domain.market;

import java.util.UUID;
import java.util.regex.Pattern;
import lombok.Getter;

@Getter
public class MarketAddress { // TODO: Customer / Market 도메인 사이 위치 고민 필요

  private UUID id;

  private UUID marketId;

  private String name;

  private String content;

  private String detail;

  private ZipCode zipCode;

  private MarketAddress(UUID id, UUID marketId, String name, String content, String detail,
                        ZipCode zipCode
  ) {
    this.id = id;
    this.marketId = marketId;
    this.name = name;
    this.content = content;
    this.detail = detail;
    this.zipCode = zipCode;
  }

  public static MarketAddress of(UUID id, UUID marketId, String name, String content, String detail, ZipCode zipCode) {
    return new MarketAddress(id, marketId, name, content, detail, zipCode);
  }

  public static MarketAddress create(UUID marketId, String name, String content, String detail, ZipCode zipCode) {
    return new MarketAddress(UUID.randomUUID(), marketId, name, content, detail, zipCode);
  }

  @Getter
  static class ZipCode {

    public static final Pattern ZIP_CODE_PATTERN = Pattern.compile("\\d{5}");
    public static final Pattern SEOUL_ZIP_CODE_CONDITION = Pattern.compile("\\b(0[1-9])*");

    private String value;

    private ZipCode(String value) {
      this.value = value;
    }

    public static ZipCode from(String value) {
      if (!ZIP_CODE_PATTERN.matcher(value).find()) {
        throw new IllegalArgumentException("우편번호는 5자리 숫자로 구성되어야 합니다.");
      }
      if (!SEOUL_ZIP_CODE_CONDITION.matcher(value).find()) {
        throw new IllegalArgumentException("서비스 가능 지역이 아닙니다.");
      }

      return new ZipCode(value);
    }
  }
}
