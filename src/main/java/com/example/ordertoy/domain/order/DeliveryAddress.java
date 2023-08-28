package com.example.ordertoy.domain.order;

import java.util.regex.Pattern;
import lombok.Getter;

@Getter
public class DeliveryAddress {

  private static final int IDX_DISTRICT_OF_ADDRESS = 2; // 시/구/동

  private String address;

  private String detailAddress;

  private ZipCode zipCode;

  private DeliveryAddress(String address, String detailAddress, ZipCode zipCode) {
    this.address = address;
    this.detailAddress = detailAddress;
    this.zipCode = zipCode;
  }

  public static DeliveryAddress of(String address, String detailAddress, String zipCode) {
    return new DeliveryAddress(address, detailAddress, ZipCode.from(zipCode));
  }

  public String findDistrict() {
    return address.split(" ")[IDX_DISTRICT_OF_ADDRESS];
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
