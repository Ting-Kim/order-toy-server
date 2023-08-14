package com.example.ordertoy.domain.common;

import java.util.UUID;
import java.util.regex.Pattern;
import lombok.Getter;

public abstract class Address {

  private UUID id;

  private UUID customerId;

  private String content;

  private String detail;

  private ZipCode zipCode;

  public Address(
      UUID id, String content, String detail, String zipCode
  ) {
    this.id = id;
    this.content = content;
    this.detail = detail;
    this.zipCode = ZipCode.from(zipCode);
  }

  @Getter
  protected static class ZipCode {

    public static final Pattern ZIP_CODE_PATTERN = Pattern.compile("\\b(0[1-9]|[1-5][0-9]|6[0-3])\\d{3}\\b");
    public static final Pattern SEOUL_ZIP_CODE_CONDITION = Pattern.compile("\\b(0[1-9])\\d{3}\\b");

    private String value;

    private ZipCode(String value) {
      this.value = value;
    }

    public static ZipCode from(String value) {
      if (!ZIP_CODE_PATTERN.matcher(value)
                           .find()) {
        throw new IllegalArgumentException("규격 외 우편번호는 생성할 수 없습니다.");
      }
      if (!SEOUL_ZIP_CODE_CONDITION.matcher(value)
                                   .find()) {
        throw new IllegalArgumentException("서비스 가능 지역이 아닙니다.");
      }

      return new ZipCode(value);
    }
  }
}
