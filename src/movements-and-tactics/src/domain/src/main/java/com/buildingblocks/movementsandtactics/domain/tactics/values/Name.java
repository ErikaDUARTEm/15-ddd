package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class Name implements IValueObject {
  private final String name;

  private Name(String name) {
    this.name = name;
  }
  public static Name of(String name){
    return new Name(name);
  }
  @Override
  public void validate() {
    validateNotEmpty(name, "name cannot be empty");
    validateNotNull(name, "name cannot be null");
  }

  public String getName() {
    return name;
  }
}
