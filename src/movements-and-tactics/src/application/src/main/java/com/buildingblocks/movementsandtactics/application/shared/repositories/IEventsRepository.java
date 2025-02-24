package com.buildingblocks.movementsandtactics.application.shared.repositories;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepository {
  Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
  void save(DomainEvent domainEvent);
}
