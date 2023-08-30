package com.example.ordertoy.persistence.market;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodJpaRepository extends JpaRepository<FoodJpaEntity, UUID> {

  List<FoodJpaEntity> findByMarketId(UUID marketId);
}
