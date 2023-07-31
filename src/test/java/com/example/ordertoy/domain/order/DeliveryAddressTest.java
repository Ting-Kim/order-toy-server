package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.order.DeliveryAddress.ZipCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeliveryAddressTest {

  @Test
  @DisplayName("주소(시/구/동)에서 행정동을 추출할 수 있어야 한다")
  void Should_ReturnDistrict_FromDeliveryAddress() {
    // given
    DeliveryAddress deliveryAddress1 = DeliveryAddress.of("서울특별시 강서구 목4동 래미안아파트",
                                                         "101동 101호",
                                                         ZipCode.from("07974"));
    DeliveryAddress deliveryAddress2 = DeliveryAddress.of("서울특별시 중랑구 면목5동 면목라온프라이빗아파트",
                                                         "101동 101호",
                                                         ZipCode.from("02225"));

    // when
    String district1 = deliveryAddress1.findDistrict();
    String district2 = deliveryAddress2.findDistrict();

    // then
    Assertions.assertThat(district1).isEqualTo("목4동");
    Assertions.assertThat(district2).isEqualTo("면목5동");
  }
}