package com.buildingblocks.movementsandtactics.infra.mongo.repositories;

import com.buildingblocks.movementsandtactics.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
}
