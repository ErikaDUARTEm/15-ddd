package com.buildingblocks.movementsandtactics.application.changeShift;


import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ChangeShiftUseCaseTest {
  private ChangeShiftUseCase useCase;
  private IEventsRepositoryPort repository;
  private Movement movement;
  @BeforeEach
  void setUp() {
    repository = Mockito.mock(IEventsRepositoryPort.class);
    useCase = new ChangeShiftUseCase(repository);
    movement = new Movement();
    List<CurrentShift> initialShifts = List.of(CurrentShift.of("initialCurrentShift", "1"));
    ShiftHistory initialHistory = ShiftHistory.of(initialShifts);
    movement.setShift(new Shift(
      ShiftId.of("initialShiftId"),
      PlayerId.of("initialPlayerId"),
      CurrentShift.of("initialCurrentShift","1"),
      initialHistory
    ));
  }

  @Test
  void executeSuccess() {
    Mockito.when(repository.findEventsByAggregateId(anyString()))
      .thenReturn(Flux.just(
        new AssignedShift(  "aggregate", "player1", "currentShiftValue")
      ));

    ChangeShiftUseCaseRequest request = new ChangeShiftUseCaseRequest( "aggregate","shift1","player1");

    StepVerifier.create(useCase.execute(request))
      .assertNext(response -> {
        assertNotNull("aggregate");
        assertNotEquals("shift1", response.getShiftId());
        assertEquals("player1", response.getPlayerId());
      })
      .verifyComplete();

    verify(repository, times(2)).save(any());

  }
}