package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;
import java.util.UUID;
import lombok.Getter;

@Getter
public class BaseDomainWrappedEvent implements DomainWrappedEvent {

  private UUID actorId;

  private UUID eventId;

  private DomainEvent<?> event;

  public BaseDomainWrappedEvent(
      UUID actorId, UUID eventId, DomainEvent<?> event
  ) {
    this.actorId = actorId;
    this.eventId = eventId;
    this.event = event;
  }
}
