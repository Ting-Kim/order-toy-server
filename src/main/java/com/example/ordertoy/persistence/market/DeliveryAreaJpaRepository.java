package com.example.ordertoy.persistence.market;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAreaJpaRepository extends JpaRepository<DeliveryAreaJpaEntity, UUID> {

}
