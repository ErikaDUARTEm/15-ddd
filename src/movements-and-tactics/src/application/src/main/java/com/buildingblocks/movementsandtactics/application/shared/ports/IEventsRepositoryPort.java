package com.buildingblocks.movementsandtactics.application.shared.ports;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepositoryPort {
  Flux<DomainEvent> findAllAggregates();
  Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
  void save(DomainEvent domainEvent);
}