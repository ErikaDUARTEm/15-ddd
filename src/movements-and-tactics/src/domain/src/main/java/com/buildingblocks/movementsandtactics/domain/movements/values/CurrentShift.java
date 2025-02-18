package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class CurrentShift implements IValueObject {
  private final ShiftId numberShift;

  private CurrentShift(ShiftId numberShift) {
    this.numberShift = numberShift;
    validate();
  }
  public static CurrentShift of(ShiftId numberShift){
    return new CurrentShift(numberShift);
  }
  @Override
  public void validate() {
    validateNotNull(numberShift, "numberShift cannot be null");
  }

  public ShiftId getNumberShift() {
    return numberShift;
  }
}
