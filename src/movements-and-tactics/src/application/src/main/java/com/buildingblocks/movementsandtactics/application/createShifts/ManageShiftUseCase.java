package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseResponse;
import com.buildingblocks.movementsandtactics.application.shared.repositories.IEventsRepository;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;
import com.buildingblocks.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.buildingblocks.movementsandtactics.application.shared.movements.MovementsMapper.mapToTable;

public class ManageShiftUseCase implements ICommandUseCase<ManageShiftUseCaseRequest, Mono<ManageShiftUseCaseResponse>> {
  private final IEventsRepository repository;

  public ManageShiftUseCase(IEventsRepository repository) {
    this.repository = repository;
  }

  @Override
  public Mono<ManageShiftUseCaseResponse> execute(ManageShiftUseCaseRequest request) {
    Movement movement = new Movement();
    movement.assignShift(request.getPlayerId(), request.getShiftId(), request.getCurrentShift());
    movement.changeShift(request.getPlayerId(), request.getShiftId());
    movement.recordShift(request.getPlayerId(), request.getShiftId());
   // movement.endShift(request.getPlayerId());


    movement.getUncommittedEvents().forEach(repository::save);
    movement.markEventsAsCommitted();
    return Mono.just(mapToTable(movement));
  }
}