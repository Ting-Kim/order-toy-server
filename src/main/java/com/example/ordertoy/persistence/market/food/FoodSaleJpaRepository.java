package com.example.ordertoy.persistence.market.food;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodSaleJpaRepository extends JpaRepository<FoodSaleJpaEntity, UUID> {

}
