package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

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
    if (numberShift < 1) {
      throw new IllegalArgumentException("Turn number must be positive and greater than 0");
    }
  }

  public Integer getNumberShift() {
    return numberShift;
  }
}
