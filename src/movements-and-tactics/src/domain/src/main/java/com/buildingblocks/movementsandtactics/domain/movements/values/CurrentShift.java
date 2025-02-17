package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

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
  public List<String> validate() {
    if (numberShift < 1) {
      throw new IllegalArgumentException("Turn number must be positive and greater than 0");
    }
    return null;
  }

  public Integer getNumberShift() {
    return numberShift;
  }
}
