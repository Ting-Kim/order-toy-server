package com.example.ordertoy.persistence.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "otoy_customer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerJpaEntity {

  @Id
  @Column(name = "customer_id")
  private UUID id;

  @Column(name = "customer_id")
  private String name;

  @Embedded
  EmbeddedMembership membership;

  @Embedded
  EmbeddableCustomerAddress address;
}
