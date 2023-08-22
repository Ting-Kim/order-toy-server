package com.example.ordertoy.web.event;

public interface DomainEventPublisher {

  void publish(DomainWrappedEvent<?> event);
}
