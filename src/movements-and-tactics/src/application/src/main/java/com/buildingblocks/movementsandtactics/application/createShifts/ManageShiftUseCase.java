package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseRequest;
import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseResponse;
import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.buildingblocks.movementsandtactics.application.shared.movements.MovementsMapper.mapToMovement;
public class ManageShiftUseCase implements ICommandUseCase<ManageShiftUseCaseRequest, Mono<ManageShiftUseCaseResponse>> {
  private final IEventsRepositoryPort repository;

  public ManageShiftUseCase(IEventsRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Mono<ManageShiftUseCaseResponse> execute(ManageShiftUseCaseRequest request) {
    Movement movement = new Movement();
    movement.assignShift(request.getAggregateId(),request.getPlayerId(), request.getCurrentShift());
    movement.recordShift(request.getPlayerId(), request.getAggregateId());
    movement.getUncommittedEvents().forEach(repository::save);
    movement.markEventsAsCommitted();
    return Mono.just(mapToMovement(movement));
  }
}