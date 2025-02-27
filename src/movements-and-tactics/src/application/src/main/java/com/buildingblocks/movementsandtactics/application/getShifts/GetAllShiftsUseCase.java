package com.buildingblocks.movementsandtactics.application.getShifts;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.application.createShifts.ManageShiftUseCase;
import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseResponse;
import com.buildingblocks.movementsandtactics.application.shared.movements.MovementsMapper;
import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;
import com.buildingblocks.shared.application.IQueryUseCase;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collectors;

public class GetAllShiftsUseCase implements IQueryUseCase<Flux<ManageShiftUseCaseResponse>> {
  private final IEventsRepositoryPort repository;

  public GetAllShiftsUseCase(IEventsRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Flux<ManageShiftUseCaseResponse> execute() {
    return repository
      .findAllAggregates()
      .collectList()
      .map(events ->events.stream().collect(Collectors.groupingBy(DomainEvent::getAggregateRootId)))
      .map(aggregates -> aggregates.entrySet().stream().map(entry->{
        entry.getValue().sort(Comparator.comparing(DomainEvent::getWhen));
        return Movement.from(entry.getKey(), entry.getValue());
      }).toList())
      .map(shifts -> shifts.stream().map(MovementsMapper::mapToMovement).toList())
      .flatMapMany(Flux::fromIterable);
  }
}
