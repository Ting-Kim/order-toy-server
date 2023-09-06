package com.example.ordertoy.persistence.market.delivery;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAreaJpaRepository extends JpaRepository<DeliveryAreaJpaEntity, UUID> {

}
