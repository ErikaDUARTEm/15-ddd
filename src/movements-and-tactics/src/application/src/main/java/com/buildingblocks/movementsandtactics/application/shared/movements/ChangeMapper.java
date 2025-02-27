package com.buildingblocks.movementsandtactics.application.shared.movements;

import com.buildingblocks.movementsandtactics.domain.movements.Movement;

public class ChangeMapper {
  public static ChangeShiftUseCaseResponse mapToChange(Movement movement) {
    System.out.println("dentro de ChangeMapper" +" " + movement.getShift().getIdentity().getValue() + " "+ movement.getIdentity().getValue() );

    return new ChangeShiftUseCaseResponse(
      movement.getIdentity().getValue(),
      movement.getPlayerId().getValue(),
      movement.getShift().getIdentity().getValue()
    );
  }
}
