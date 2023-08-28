package com.example.ordertoy.persistence.customer;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.customer.CustomerAddress;
import com.example.ordertoy.domain.customer.Membership;
import com.example.ordertoy.domain.market.Food;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerAdapter {

  private final CustomerJpaRepository customerRepository;
  private final CustomerAddressJpaRepository customerAddressRepository;

  public Optional<Customer> findById(UUID id) {
    List<CustomerAddress> customerAddresses =
        customerAddressRepository.findAllByCustomerId(id)
                                 .stream()
                                 .map(c -> CustomerAddress.of(c.getId(),
                                                              c.getCustomerId(),
                                                              c.getName(),
                                                              c.getContent(),
                                                              c.getDetail(),
                                                              c.getZipCode()))
                                 .toList();
    return customerRepository.findById(id)
                             .map(c -> Customer.of(c.getId(),
                                                   c.getName(),
                                                   Membership.of(c.getMembershipGrade(),
                                                                 c.getMembershipPoint()),
                                                   customerAddresses));
  }
}
