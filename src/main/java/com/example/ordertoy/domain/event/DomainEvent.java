package com.example.ordertoy.domain.event;

public interface DomainEvent<T> {

  T getSource();

  String getAggregateType();
}
