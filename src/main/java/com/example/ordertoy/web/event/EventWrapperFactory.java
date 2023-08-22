package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;
import java.util.UUID;

public interface EventWrapperFactory {

  DomainWrappedEvent<?> createWrapper(DomainEvent<?> event, UUID actorId);
}
