package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class Name implements IValueObject {
  private final TypeTactic name;

  private Name(final TypeTactic name) {
    this.name = name;
  }
  public static Name of(TypeTactic name){
    return new Name(name);
  }
  @Override
  public void validate() {
    validateNotEmpty(String.valueOf(name), "name cannot be empty");
    validateNotNull(name, "name cannot be null");
  }

  public TypeTactic getName() {
    return name;
  }
}
