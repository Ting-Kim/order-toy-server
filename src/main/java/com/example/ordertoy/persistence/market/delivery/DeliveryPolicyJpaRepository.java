package com.example.ordertoy.persistence.market.delivery;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPolicyJpaRepository extends JpaRepository<DeliveryPolicyJpaEntity, UUID> {

  Optional<DeliveryPolicyJpaEntity> findByMarketId(UUID marketId);
}
