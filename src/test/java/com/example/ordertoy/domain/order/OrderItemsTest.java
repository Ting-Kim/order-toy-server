package com.example.ordertoy.domain.order;

import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.Market;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderItemsTest {

    @Test
    @DisplayName("주문 내역에 서로 다른 가게의 메뉴가 존재하면 예외를 발생시킨다")
    void Should_ThrowException_WhenAnotherOrderItemsOfMarkets() {
        // given
        Food chicken = Food.of("치킨", 18000, 90);
        Food friedPotato = Food.of("감자튀김", 5000, 30);
        Food coke = Food.of("콜라", 3000, 5);
        Market blueChicken = Market.of("파랑통닭", "판교로228번길 18 101호");
        Market papasTouch = Market.of("파파스터치", "판교로228번길 6 101호");
        OrderItem orderItem1 = OrderItem.of(chicken, 1, blueChicken);
        OrderItem orderItem2 = OrderItem.of(friedPotato, 1, papasTouch);
        OrderItem orderItem3 = OrderItem.of(coke, 3, blueChicken);

        // when & then
        Assertions.assertThatThrownBy(() -> OrderItems.from(List.of(orderItem1, orderItem2, orderItem3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 가게");
    }
}