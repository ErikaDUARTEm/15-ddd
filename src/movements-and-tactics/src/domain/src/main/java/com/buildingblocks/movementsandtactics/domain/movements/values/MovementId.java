package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class MovementId extends Identity {
  public MovementId() {
    super();
  }
  private MovementId(String id) {
    super(id);
  }
  public static MovementId of(String id){
    return new MovementId(id);
  }
}
