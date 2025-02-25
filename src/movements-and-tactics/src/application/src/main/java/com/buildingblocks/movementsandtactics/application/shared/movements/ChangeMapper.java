package com.buildingblocks.movementsandtactics.application.shared.movements;

import com.buildingblocks.movementsandtactics.domain.movements.Movement;

public class ChangeMapper {
  public static ChangeShiftUseCaseResponse mapToChange(Movement movement) {
    if(movement.getShift() == null){
      throw new IllegalStateException("El aggregate Movement no tiene un Shift asignado.");
    }
    return new ChangeShiftUseCaseResponse(
      movement.getShift().getIdentity().getValue(),
      movement.getPlayerId().getValue()
    );
  }
}
