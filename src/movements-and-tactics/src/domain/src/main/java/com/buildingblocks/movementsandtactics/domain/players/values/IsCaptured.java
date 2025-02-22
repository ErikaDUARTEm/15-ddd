package com.buildingblocks.movementsandtactics.domain.players.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class IsCaptured implements IValueObject {
  private final Boolean value;

  private IsCaptured(Boolean value) {
    this.value = value;
    validate();
  }
  public static IsCaptured of(Boolean value){
    return new IsCaptured(value);
  }
  @Override
  public void validate() {
    validateNotNull(value, "value cannot be null");
  }

  public Boolean getValue() {
    return value;
  }
}