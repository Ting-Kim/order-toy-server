package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;

import java.util.UUID;

public interface DomainWrappedEvent<T extends DomainEvent<?>> {

  UUID getActorId();

  UUID getEventId();

  T getEvent();

  default String getAggregateType() {
    return getEvent().getAggregateType();
  };
}
