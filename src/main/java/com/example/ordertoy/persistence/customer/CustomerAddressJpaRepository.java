package com.example.ordertoy.persistence.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressJpaRepository extends JpaRepository<CustomerAddressJpaEntity, UUID> {

  List<CustomerAddressJpaEntity> findAllByCustomerId(UUID customerId);

}
