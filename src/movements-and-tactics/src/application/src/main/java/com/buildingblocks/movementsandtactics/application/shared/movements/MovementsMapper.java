package com.buildingblocks.movementsandtactics.application.shared.movements;

import com.buildingblocks.movementsandtactics.domain.movements.Movement;

public class MovementsMapper {
  public static ManageShiftUseCaseResponse mapToMovement(Movement movement) {
    System.out.println("dentro de MovementMapper" +" " + movement.getShift().getIdentity().getValue() + " "+ movement.getIdentity().getValue() );

    return new ManageShiftUseCaseResponse(
      movement.getIdentity().getValue(),
      movement.getShift().getIdentity().getValue(),
      movement.getPlayerId().getValue(),
      movement.getShift().getCurrentShift().getNumberShift()
    );
  }
}
