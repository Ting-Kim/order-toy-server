package com.example.ordertoy.persistence.customer;

import com.example.ordertoy.domain.customer.Grade;
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

  @Column(name = "customer_name")
  private String name;

  @Embedded
  EmbeddedMembership membership;

  public CustomerJpaEntity(UUID id, String name, EmbeddedMembership membership) {
    this.id = id;
    this.name = name;
    this.membership = membership;
  }

  public Grade getMembershipGrade() {
    return membership.getGrade();
  }

  public Integer getMembershipPoint() {
    return membership.getPoint();
  }
}
