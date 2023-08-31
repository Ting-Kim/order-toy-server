package com.example.ordertoy.persistence.market;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTipStandardJpaRepository extends JpaRepository<DeliveryTipStandardJpaEntity, UUID> {

  List<DeliveryTipStandardJpaEntity> findAllByDeliveryPolicyId(UUID deliveryPolicyId);
}
