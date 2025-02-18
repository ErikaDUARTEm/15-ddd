package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class CurrentShift implements IValueObject {
  private final Integer numberShift;

  private CurrentShift(Integer numberShift) {
    this.numberShift = numberShift;
    validate();
  }
  public static CurrentShift of(Integer numberShift){
    return new CurrentShift(numberShift);
  }
  @Override
  public void validate() {
    validateNotNull(numberShift, "numberShift cannot be null");
  }

  public Integer getNumberShift() {
    return numberShift;
  }
}
