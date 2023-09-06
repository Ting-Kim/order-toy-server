package com.example.ordertoy.persistence.market.food;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_food_sale")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodSaleJpaEntity {

  @Id
  @Column(name = "food_sale_id")
  private UUID id;

  @Column(name = "food_id")
  private UUID foodId;

  @Column(name = "sales_count")
  private Integer salesCount;

  private FoodSaleJpaEntity(UUID id, UUID foodId, Integer salesCount) {
    this.id = id;
    this.foodId = foodId;
    this.salesCount = salesCount;
  }

  public static FoodSaleJpaEntity of(UUID id, UUID foodId, Integer salesCount) {
    return new FoodSaleJpaEntity(id, foodId, salesCount);
  }
}
