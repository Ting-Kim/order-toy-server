package com.example.ordertoy.persistence.order;

import com.example.ordertoy.domain.order.OrderItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, UUID> {

}
