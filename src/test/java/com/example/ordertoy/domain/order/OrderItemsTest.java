package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.BlackCustomers;
import com.example.ordertoy.domain.market.DeliveryArea;
import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import com.example.ordertoy.domain.market.MarketAddress;
import java.util.Collections;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderItemsTest {

  @Test
  @DisplayName("주문 내역에 서로 다른 가게의 메뉴가 존재하면 예외를 발생시킨다")
  void Should_ThrowException_WhenOrderItemsOfAnotherMarkets() {
    // given
    Market blueChicken = Market.create("파랑통닭", MarketAddress.create("다산로6길 7-10", "101호", "04597"),
                                       Collections.emptyList(), 10000,
                                       Lists.list(DeliveryArea.of(UUID.randomUUID(), "신정1동")),
                                       BlackCustomers.from(List.of()));
    Market papasTouch = Market.create("파파스터치", MarketAddress.create("다산로6길 7-10", "101호", "04597"),
                                      Collections.emptyList(), 10000,
                                      Lists.list(DeliveryArea.of(UUID.randomUUID(), "신정1동")),
                                      BlackCustomers.from(List.of()));
    Food chicken = Food.create(blueChicken.getId(), "치킨", 18000, 90);
    Food friedPotato = Food.create(blueChicken.getId(), "감자튀김", 5000, 30);
    Food coke = Food.create(papasTouch.getId(), "콜라", 3000, 5);
    OrderItem orderItem1 = OrderItem.create(blueChicken.getId(), chicken, 1);
    OrderItem orderItem2 = OrderItem.create(blueChicken.getId(), friedPotato, 1);
    OrderItem orderItem3 = OrderItem.create(papasTouch.getId(), coke, 3);

    // when & then
    Assertions.assertThatThrownBy(
                  () -> OrderItems.from(List.of(orderItem1, orderItem2, orderItem3)))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("한 가게");
  }

  @Test
  @DisplayName("주문 내역에 한 가게의 메뉴들이 담기면 정상적으로 생성된다")
  void Should_Pass_WhenOrderItemsOfSameMarkets() {
    // given
    Market blueChicken = Market.create("파랑통닭", MarketAddress.create("다산로6길 7-10", "101호", "04597"),
                                       Collections.emptyList(), 10000,
                                       Lists.list(DeliveryArea.of(UUID.randomUUID(), "신정1동")),
                                       BlackCustomers.from(List.of()));
    Food chicken = Food.create(blueChicken.getId(), "치킨", 18000, 90);
    Food friedPotato = Food.create(blueChicken.getId(), "감자튀김", 5000, 30);
    Food coke = Food.create(blueChicken.getId(), "콜라", 3000, 5);
    OrderItem orderItem1 = OrderItem.create(blueChicken.getId(), chicken, 1);
    OrderItem orderItem2 = OrderItem.create(blueChicken.getId(), friedPotato, 1);
    OrderItem orderItem3 = OrderItem.create(blueChicken.getId(), coke, 3);

    // when & then
    Assertions.assertThat(OrderItems.from(List.of(orderItem1, orderItem2, orderItem3)))
              .isNotNull();
  }
}