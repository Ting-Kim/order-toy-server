package com.example.ordertoy.persistence.market;

import com.example.ordertoy.domain.market.Food;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodJpaEntity {

  @Id
  @Column(name = "food_id")
  private UUID id;

  @Column(name = "market_id")
  private UUID marketId;

  @Column(name = "food_name")
  private String name;

  @Column(name = "price")
  private Integer price;

  @Column(name = "average_minute_required")
  private Integer averageMinuteRequired;

  private FoodJpaEntity(
      UUID id, UUID marketId, String name, Integer price, Integer averageMinuteRequired
  ) {
    this.id = id;
    this.marketId = marketId;
    this.name = name;
    this.price = price;
    this.averageMinuteRequired = averageMinuteRequired;
  }

  public static FoodJpaEntity of(
      UUID id, UUID marketId, String name, Integer price, Integer averageMinuteRequired
  ) {
    return new FoodJpaEntity(id, marketId, name, price, averageMinuteRequired);
  }

  public static FoodJpaEntity create(
      UUID marketId, String name, Integer price
  ) {
    return new FoodJpaEntity(UUID.randomUUID(),
                             marketId,
                             name,
                             price,
                             Food.INIT_AVERAGE_MINUTE_REQUIRED);
  }
}
