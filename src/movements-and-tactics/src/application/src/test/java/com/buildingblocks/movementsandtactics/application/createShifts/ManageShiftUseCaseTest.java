package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.movementsandtactics.application.shared.movements.ManageShiftUseCaseRequest;
import com.buildingblocks.movementsandtactics.application.shared.ports.IEventsRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ManageShiftUseCaseTest {
  private  ManageShiftUseCase useCase;
  private IEventsRepositoryPort repository;

  @BeforeEach
  void setUp() {
    repository = Mockito.mock(IEventsRepositoryPort.class);
    useCase = new ManageShiftUseCase(repository);
  }

  @Test
  void executeSuccess() {
    when(repository.findEventsByAggregateId(anyString()))
      .thenReturn(Flux.empty());

    ManageShiftUseCaseRequest request = new ManageShiftUseCaseRequest( "player1", "shift1");

    StepVerifier.create(useCase.execute(request))
      .assertNext(response -> {
        assertEquals("player1", response.getPlayerId());
        assertEquals("shift1", response.getCurrentShift());
      })
      .verifyComplete();

    verify(repository, times(1)).save(any());

   }
}