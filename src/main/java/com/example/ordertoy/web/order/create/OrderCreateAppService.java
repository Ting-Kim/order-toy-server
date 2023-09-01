package com.example.ordertoy.web.order.create;

import com.example.ordertoy.domain.customer.Customer;
import com.example.ordertoy.domain.customer.CustomerAddress;
import com.example.ordertoy.domain.market.Market;
import com.example.ordertoy.domain.order.DeliveryAddress;
import com.example.ordertoy.domain.order.OrderItem;
import com.example.ordertoy.domain.order.OrderItems;
import com.example.ordertoy.persistence.customer.CustomerAdapter;
import com.example.ordertoy.persistence.market.FoodAdapter;
import com.example.ordertoy.persistence.market.MarketAdapter;
import com.example.ordertoy.persistence.order.OrderAdapter;
import com.example.ordertoy.web.event.DomainEventPublisher;
import com.example.ordertoy.domain.order.OrderCreateCommand;
import com.example.ordertoy.domain.order.event.OrderCreatedEvent;
import com.example.ordertoy.domain.order.service.OrderCommandService;
import com.example.ordertoy.web.event.ConfigBasedEventWrapperFactory;
import com.example.ordertoy.web.event.DomainWrappedEvent;
import com.example.ordertoy.web.order.create.rqrs.OrderCreateOrderItemRq;
import com.example.ordertoy.web.order.create.rqrs.OrderCreateRq;
import com.example.ordertoy.web.order.create.rqrs.OrderCreateRs;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderCreateAppService {

  private OrderCommandService orderCommandService;
  private FoodAdapter foodAdapter;
  private CustomerAdapter customerAdapter;
  private MarketAdapter marketAdapter;
  private OrderAdapter orderAdapter;
  private DomainEventPublisher domainEventPublisher;
  private ConfigBasedEventWrapperFactory configBasedEventWrapperFactory;

  public OrderCreateRs createOrder(UUID actorId, OrderCreateRq rq) {
    Map<UUID, Integer> countByFoodId = rq.getOrderItems()
                                         .stream()
                                         .collect(
                                             Collectors.toMap(OrderCreateOrderItemRq::getFoodId,
                                                              OrderCreateOrderItemRq::getCount,
                                                              Integer::sum));
    OrderItems orderItems =
        OrderItems.from(foodAdapter.findAllById(countByFoodId.keySet()
                                                             .stream()
                                                             .toList())
                                   .stream()
                                   .map(f -> OrderItem.create(rq.getMarketId(),
                                                              f,
                                                              countByFoodId.get(f.getId())))
                                   .toList());
    Customer customer = customerAdapter.findById(rq.getCustomerId())
                                       .orElseThrow(IllegalArgumentException::new);

    CustomerAddress address = customer.findAddressById(rq.getCustomerAddressId());

    Market market = marketAdapter.findById(rq.getMarketId());

    OrderCreatedEvent orderCreatedEvent = orderCommandService.createOrder(
        new OrderCreateCommand(orderItems,
                               customer,
                               DeliveryAddress.of(address.getContent(),
                                                  address.getDetail(),
                                                  address.getZipCodeValue()),
                               market));

  orderAdapter.save(orderCreatedEvent.getSource());

    // OrderCreatedEvent, DeliveryRequestedEvent, ..
    DomainWrappedEvent<?> wrappedEvent =
        configBasedEventWrapperFactory.createWrapper(orderCreatedEvent, actorId);

    domainEventPublisher.publish(wrappedEvent);

    return new OrderCreateRs(orderCreatedEvent.getSource()
                                              .getId());
  }

}
