package com.example.ordertoy.web.event;

import com.example.ordertoy.domain.event.DomainEvent;
import com.example.ordertoy.domain.order.event.OrderCreatedEvent;
import com.example.ordertoy.web.order.create.event.OrderCreatedWrappedEvent;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class ConfigBasedEventWrapperFactory implements EventWrapperFactory {

  private Map<Class<? extends DomainEvent<?>>, Function<BaseDomainWrappedEvent, DomainWrappedEvent<?>>> wrapperMappings
      = new HashMap<>();;

  public ConfigBasedEventWrapperFactory(
      Map<Class<? extends DomainEvent<?>>, Function<BaseDomainWrappedEvent, DomainWrappedEvent<?>>> wrapperMappings
  ) {
    this.wrapperMappings = wrapperMappings;
  }

  @PostConstruct
  public void init() {
    wrapperMappings.put(OrderCreatedEvent.class, OrderCreatedWrappedEvent::from);
  }

  @Override
  public DomainWrappedEvent<?> createWrapper(DomainEvent<?> event, UUID actorId) {
    if (wrapperMappings.containsKey(event.getClass())) {
      return null;
    }

    return wrapperMappings.get(event.getClass())
                          .apply(new BaseDomainWrappedEvent(actorId, UUID.randomUUID(), event));
  }
}
