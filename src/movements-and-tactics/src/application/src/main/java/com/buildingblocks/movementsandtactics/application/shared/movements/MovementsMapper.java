package com.buildingblocks.movementsandtactics.application.shared.movements;

import com.buildingblocks.movementsandtactics.domain.movements.Movement;

public class MovementsMapper {
  public static ManageShiftUseCaseResponse mapToMovement(Movement movement) {

    return new ManageShiftUseCaseResponse(
      movement.getShift().getIdentity().getValue(),
      movement.getPlayerId().getValue(),
      movement.getShift().getCurrentShift().getNumberShift()
    );
  }
}
