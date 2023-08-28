package com.example.ordertoy.persistence.market;

import com.example.ordertoy.domain.market.Food;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodAdapter {

  private final FoodJpaRepository foodRepository;

  public List<Food> findAllById(List<UUID> ids) {
    return foodRepository.findAllById(ids)
                         .stream()
                         .map(f -> Food.of(f.getId(),
                                           f.getMarketId(),
                                           f.getName(),
                                           f.getPrice(),
                                           f.getAverageMinuteRequired()))
                         .toList();
  }
}
