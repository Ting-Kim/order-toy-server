package com.example.ordertoy.web.order.create.event;

import com.example.ordertoy.domain.order.event.OrderCreatedEvent;
import com.example.ordertoy.web.event.BaseDomainWrappedEvent;
import com.example.ordertoy.web.event.DomainWrappedEvent;
import java.util.UUID;
import lombok.Getter;

@Getter
public class OrderCreatedWrappedEvent implements DomainWrappedEvent<OrderCreatedEvent> {

  private String aggregateType;

  private UUID actorId;

  private UUID eventId;

  private OrderCreatedEvent event;

  private OrderCreatedWrappedEvent(
      String aggregateType, UUID actorId, UUID eventId, OrderCreatedEvent event
  ) {
    this.aggregateType = aggregateType;
    this.actorId = actorId;
    this.eventId = eventId;
    this.event = event;
  }

  public static OrderCreatedWrappedEvent of(
      OrderCreatedEvent event,
      String aggregateType,
      UUID actorId
  ) {
    return new OrderCreatedWrappedEvent(aggregateType,
                                        actorId,
                                        UUID.randomUUID(),
                                        event);
  }

  public static OrderCreatedWrappedEvent from(
      BaseDomainWrappedEvent baseEvent
  ) {
    return new OrderCreatedWrappedEvent(baseEvent.getAggregateType(),
                                        baseEvent.getActorId(),
                                        UUID.randomUUID(),
                                        (OrderCreatedEvent) baseEvent.getEvent());
  }
}