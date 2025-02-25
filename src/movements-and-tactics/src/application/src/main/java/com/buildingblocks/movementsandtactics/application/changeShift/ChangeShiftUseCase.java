package com.buildingblocks.movementsandtactics.application.changeShift;

import com.buildingblocks.movementsandtactics.application.shared.movements.ChangeShiftUseCaseResponse;
import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;
import static com.buildingblocks.movementsandtactics.application.shared.movements.ChangeMapper.mapToChange;

public class ChangeShiftUseCase implements ICommandUseCase<ChangeShiftUseCaseRequest, Mono<ChangeShiftUseCaseResponse>> {
  private final IEventsRepositoryPort repository;

  public ChangeShiftUseCase(IEventsRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Mono<ChangeShiftUseCaseResponse> execute(ChangeShiftUseCaseRequest request) {
    return repository
      .findEventsByAggregateId(request.getAggregateId())
      .collectList()
      .map(events -> {
        Movement movement = Movement.from(request.getAggregateId(), events);
          movement.changeShift(request.getPlayerId(), request.getShiftId());
          movement.recordShift(request.getPlayerId(), request.getShiftId());
          movement.getUncommittedEvents().forEach(repository::save);
          movement.markEventsAsCommitted();
          return mapToChange(movement);
    });
  }
}
