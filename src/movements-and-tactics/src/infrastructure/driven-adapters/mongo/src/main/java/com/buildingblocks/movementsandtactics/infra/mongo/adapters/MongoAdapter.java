package com.buildingblocks.movementsandtactics.infra.mongo.adapters;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.movementsandtactics.infra.mongo.entities.Event;
import com.buildingblocks.movementsandtactics.infra.mongo.repositories.IEventsRepository;
import reactor.core.publisher.Flux;

public class MongoAdapter implements IEventsRepositoryPort {
  private final IEventsRepository eventsRepository;

  public MongoAdapter(IEventsRepository eventsRepository) {
    this.eventsRepository = eventsRepository;
  }

  @Override
  public Flux<DomainEvent> findAllAggregates() {
    return eventsRepository.findAll().map(Event::getDomainEvent);
  }

  @Override
  public Flux<DomainEvent> findEventsByAggregateId(String aggregateId) {
    return findAllAggregates().filter(event -> event.getAggregateRootId().equals(aggregateId));
  }

  @Override
  public void save(DomainEvent domainEvent) {
    eventsRepository.save(new Event(domainEvent)).subscribe();
  }
}