package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class CurrentShift implements IValueObject {
  private final String shiftId;

  private CurrentShift(String shiftId) {
    this.shiftId = shiftId;
    validate();
  }
  public static CurrentShift of(String shiftId){
    return new CurrentShift(shiftId);
  }
  @Override
  public void validate() {
    validateNotNull(shiftId, "numberShift cannot be null");
  }

  public String getNumberShift() {
    return shiftId;
  }
}
