package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;
import java.util.UUID;

public class BasedDomainWrappedEvent implements DomainWrappedEvent {

  private UUID aggregateId;

  private String aggregateType;

  private UUID actorId;

  private UUID eventId;

  private DomainEvent<?> event;

  public BasedDomainWrappedEvent(
      UUID aggregateId, String aggregateType, UUID actorId, UUID eventId, DomainEvent<?> event
  ) {
    this.aggregateId = aggregateId;
    this.aggregateType = aggregateType;
    this.actorId = actorId;
    this.eventId = eventId;
    this.event = event;
  }

  public UUID getAggregateId() {
    return aggregateId;
  }

  public String getAggregateType() {
    return aggregateType;
  }

  public UUID getActorId() {
    return actorId;
  }

  public UUID getEventId() {
    return eventId;
  }

  public DomainEvent<?> getEvent() {
    return event;
  }
}
