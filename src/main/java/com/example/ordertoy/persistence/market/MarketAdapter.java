package com.example.ordertoy.persistence.market;

import com.example.ordertoy.domain.market.Market;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarketAdapter {

  private final MarketJpaRepository marketRepository;
  private final MarketAddressJpaRepository marketAddressRepository;
  private final FoodSaleJpaRepository foodSaleRepository;
  private final FoodJpaRepository foodRepository;
  private final DeliveryPolicyJpaRepository deliveryPolicyRepository;
  private final DeliveryTipStandardJpaRepository deliveryTipStandardRepository;
  private final DeliveryAreaJpaRepository deliveryAreaRepository;
  private final MarketMapper marketMapper;

  public Market findById(UUID marketId) {
    MarketJpaEntity market = marketRepository.findById(marketId)
                                             .orElseThrow(EntityNotFoundException::new);
    MarketAddressJpaEntity marketAddress =
        marketAddressRepository.findByMarketId(marketId)
                               .orElseThrow(EntityNotFoundException::new);
    Map<UUID, FoodJpaEntity> foodById = foodRepository.findByMarketId(marketId)
                                                     .stream()
                                                     .collect(Collectors.toMap(FoodJpaEntity::getId,
                                                                               f -> f,
                                                                               (f1, f2) -> f1));
    List<FoodSaleJpaEntity> foodSales = foodSaleRepository.findAllById(foodById.keySet());

    DeliveryPolicyJpaEntity deliveryPolicy =
        deliveryPolicyRepository.findByMarketId(marketId)
                                .orElseThrow(EntityNotFoundException::new);

    List<DeliveryTipStandardJpaEntity> deliveryTipStandards =
        deliveryTipStandardRepository.findAllByMarketId(marketId);

    List<DeliveryAreaJpaEntity> deliveryAreas = deliveryAreaRepository.findAllById(
        deliveryPolicy.getAvailableDeliveryAreaIds());

    return marketMapper.mapToDomain(market,
                                    marketAddress,
                                    foodSales,
                                    foodById,
                                    deliveryPolicy,
                                    deliveryTipStandards,
                                    deliveryAreas,
                                    market.getBlackCustomerIds());

  }
}
