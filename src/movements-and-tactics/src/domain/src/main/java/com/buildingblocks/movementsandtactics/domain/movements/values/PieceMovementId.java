package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class PieceMovementId extends Identity {
  public PieceMovementId() {
    super();
  }
  private PieceMovementId(String id) {
    super(id);
  }
  public static PieceMovementId of(String id){
    return new PieceMovementId(id);
  }
}
