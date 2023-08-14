package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.market.BlackCustomers;
import com.example.ordertoy.domain.market.DeliveryArea;
import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import com.example.ordertoy.domain.market.MarketAddress;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  @DisplayName("블랙리스트에 존재하는 고객의 주문의 경우, 주문 검증 시 예외가 발생한다")
  void Should_ThrowException_When_OrderedByBlackConsumer() {
    // given
    Customer blackConsumer = Customer.create("Black");
    Market blueChicken = Market.create("파랑통닭", MarketAddress.create("다산로6길 7-10", "101호", "04597"),
                                       Collections.emptyList(), 10000,
                                       Lists.list(DeliveryArea.from("신정1동")),
                                       BlackCustomers.from(List.of(blackConsumer.getId())));
    Food chicken = Food.create(blueChicken.getId(), "치킨", 18000, 90);
    Food friedPotato = Food.create(blueChicken.getId(), "감자튀김", 5000, 30);
    Food coke = Food.create(blueChicken.getId(), "콜라", 3000, 5);
    OrderItem orderItem1 = OrderItem.of(chicken, 1);
    OrderItem orderItem2 = OrderItem.of(friedPotato, 1);
    OrderItem orderItem3 = OrderItem.of(coke, 3);
    Order order = Order.create(OrderItems.from(List.of(orderItem1,
                                                       orderItem2,
                                                       orderItem3)),
                               blackConsumer,
                               DeliveryAddress.of("판교로 10번길 56",
                                                  "이편한세상 101동 1503호",
                                                  DeliveryAddress.ZipCode.from("09622")),
                               blueChicken);

    // when & then
    Assertions.assertThatThrownBy(() -> order.validate())
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("블랙리스트");
  }
}