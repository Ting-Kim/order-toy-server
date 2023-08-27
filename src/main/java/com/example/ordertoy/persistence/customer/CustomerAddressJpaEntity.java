package com.example.ordertoy.persistence.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "otoy_customer_address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerAddressJpaEntity {

  @Id
  @Column(name = "customer_address_id")
  private UUID id;

  @Column(name = "customer_id")
  private UUID customerId;

  @Column(name = "customer_address_name")
  private String name;

  @Column(name = "content")
  private String content;

  @Column(name = "detail_content")
  private String detail;

  @Column(name = "zip_code")
  private String zipCode;

  public CustomerAddressJpaEntity(
      UUID id, UUID customerId, String name, String content, String detail, String zipCode
  ) {
    this.id = id;
    this.customerId = customerId;
    this.name = name;
    this.content = content;
    this.detail = detail;
    this.zipCode = zipCode;
  }
}
