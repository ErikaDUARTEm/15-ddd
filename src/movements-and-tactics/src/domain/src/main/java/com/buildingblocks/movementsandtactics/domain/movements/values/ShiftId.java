package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;


public class ShiftId extends Identity {
  public ShiftId() {
    super();
  }
  private ShiftId(String id) {
    super(id);
  }
  public static ShiftId of(String id){
    return new ShiftId(id);
  }

}
