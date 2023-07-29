package com.example.ordertoy.domain.common;

import com.example.ordertoy.domain.common.Address.ZipCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddressTest {

  @Test
  @DisplayName("5자리 이상의 우편번호는 생성 시 예외가 발생한다")
  void Should_ThrowException_WhenCreateLongerZipCode() {
    // given
    String zipCode = "089029";

    // when & then
    Assertions.assertThatThrownBy(() -> ZipCode.from(zipCode))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("규격 외 우편번호");
  }

  @Test
  @DisplayName("규격 외 우편번호는 생성 시 예외가 발생한다")
  void Should_ThrowException_WhenCreateAbnormalZipCode() {
    // given
    String zipCode = "00902";

    // when & then
    Assertions.assertThatThrownBy(() -> ZipCode.from(zipCode))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("규격 외 우편번호");
  }

  @Test
  @DisplayName("숫자로 이루어지지 않은 우편번호는 생성 시 예외가 발생한다")
  void Should_ThrowException_WhenCreateNotOnlyNumbersZipCode() {
    // given
    String zipCode = "08a29";

    // when & then
    Assertions.assertThatThrownBy(() -> ZipCode.from(zipCode))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("규격 외 우편번호");
  }

  @Test
  @DisplayName("사울 이외 우편번호의 경우는 생성 시 예외가 발생한다")
  void Should_ThrowException_WhenCreateNotOfSeoulZipCode() {
    // when & then
    Assertions.assertThatThrownBy(() -> ZipCode.from("50129"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("서비스 가능 지역이 아닙니다");
    Assertions.assertThatThrownBy(() -> ZipCode.from("18129"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("서비스 가능 지역이 아닙니다");
    Assertions.assertThatThrownBy(() -> ZipCode.from("11000"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("서비스 가능 지역이 아닙니다");
  }
}