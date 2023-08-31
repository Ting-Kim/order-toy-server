package com.example.ordertoy.persistence.market;

import com.example.ordertoy.domain.market.BlackCustomers;
import com.example.ordertoy.domain.market.DeliveryArea;
import com.example.ordertoy.domain.market.DeliveryPolicy;
import com.example.ordertoy.domain.market.DeliveryTipStandard;
import com.example.ordertoy.domain.market.Food;
import com.example.ordertoy.domain.market.FoodSale;
import com.example.ordertoy.domain.market.Market;
import com.example.ordertoy.domain.market.MarketAddress;
import com.example.ordertoy.domain.market.Sales;
import com.example.ordertoy.persistence.customer.CustomerJpaEntity;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MarketMapper {

  Market mapToDomain(MarketJpaEntity market,
                     MarketAddressJpaEntity marketAddress,
                     List<FoodSaleJpaEntity> foodSales,
                     Map<UUID, FoodJpaEntity> foodById,
                     DeliveryPolicyJpaEntity deliveryPolicy,
                     List<DeliveryTipStandardJpaEntity> deliveryTipStandards,
                     List<DeliveryAreaJpaEntity> deliveryAreas,
                     List<UUID> blackCustomerIds) {
    return Market.of(market.getId(),
                     market.getName(),
                     MarketAddress.of(marketAddress.getId(),
                                      marketAddress.getAddress(),
                                      marketAddress.getDetailAddress(),
                                      marketAddress.getZipCode()),
                     Sales.of(market.getId(),
                              foodSales.stream()
                                       .map(s -> {
                                         FoodJpaEntity food = foodById.get(s.getFoodId());
                                         return FoodSale.of(Food.of(food.getId(),
                                                                    market.getId(),
                                                                    food.getName(),
                                                                    food.getPrice(),
                                                                    food.getAverageMinuteRequired()),
                                                            s.getSalesCount());
                                       })
                                       .collect(Collectors.toList())),
                     DeliveryPolicy.of(deliveryPolicy.getId(),
                                       deliveryPolicy.getMarketId(),
                                       deliveryPolicy.getMinimumOrderPrice(),
                                       deliveryTipStandards.stream()
                                           .map(t -> DeliveryTipStandard.of(t.getOrderPriceMoreThan(),
                                                                            t.getOrderPriceUnder(),
                                                                            t.getDeliveryPrice()))
                                           .collect(Collectors.toList()),
                                       deliveryAreas.stream()
                                                    .map(a -> DeliveryArea.of(a.getId(),
                                                                              a.getDistrict()))
                                                    .collect(Collectors.toList())),
                     BlackCustomers.from(blackCustomerIds));

  }
}
