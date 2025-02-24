package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.movementsandtactics.application.shared.repositories.IEventsRepository;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class ManageShiftUseCaseTest {
  private  ManageShiftUseCase useCase;
  private  IEventsRepository repository;

  @BeforeEach
  void setUp() {
    repository = Mockito.mock(IEventsRepository.class);
    useCase = new ManageShiftUseCase(repository);
  }

  @Test
  void executeSuccess() {
    Shift shift = new Shift(PlayerId.of("playerId"), CurrentShift.of("shiftId", "playerId"));
    ManageShiftUseCaseRequest request = new ManageShiftUseCaseRequest("playerId", "shiftId", shift.getCurrentShift().getNumberShift());
    StepVerifier
      .create(useCase.execute(request))
      .assertNext(response -> {
        assertNotNull(response);
        assertEquals("playerId", response.getPlayerId());
        assertEquals("shiftId", response.getShiftId());
        assertEquals("currentShift", response.getCurrentShift());
      })
      .verifyComplete();
   Mockito.verify(repository, times(4)).save(any());

   }
}