package com.buildingblocks.movementsandtactics.application.shared.movements;

import com.buildingblocks.movementsandtactics.domain.movements.Movement;

public class MovementsMapper {
  public static ManageShiftUseCaseResponse mapToTable(Movement movement) {
    return new ManageShiftUseCaseResponse(
      movement.getShift().getPlayerId().getValue(),
      movement.getShift().getIdentity().getValue(),
      movement.getShift().getCurrentShift().getNumberShift()
    );
  }
}
