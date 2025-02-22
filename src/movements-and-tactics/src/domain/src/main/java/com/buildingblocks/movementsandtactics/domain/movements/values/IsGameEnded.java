package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class IsGameEnded implements IValueObject {
  private final Boolean value;

  private IsGameEnded(Boolean value) {
    this.value = value;
    validate();
  }
  public static IsGameEnded of(Boolean value){
    return new IsGameEnded(value);
  }
  @Override
  public void validate() {
    validateNotNull(value, "value cannot be null");
  }

  public Boolean getValue() {
    return value;
  }


}
