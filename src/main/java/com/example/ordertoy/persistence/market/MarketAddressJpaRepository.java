package com.example.ordertoy.persistence.market;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketAddressJpaRepository extends
    JpaRepository<MarketAddressJpaEntity, UUID> {

  Optional<MarketAddressJpaEntity> findByMarketId(UUID marketId);
}
