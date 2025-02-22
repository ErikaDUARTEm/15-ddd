package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class IsValid implements IValueObject {
  private final Boolean value;

  private IsValid(Boolean value) {
    this.value = value;
    validate();
  }

  public static IsValid of(Boolean value) {
    return new IsValid(value);
  }

  @Override
  public void validate() {
    validateNotNull(value, "value cannot be null");
  }

  public Boolean getValue() {
    return value;
  }
}