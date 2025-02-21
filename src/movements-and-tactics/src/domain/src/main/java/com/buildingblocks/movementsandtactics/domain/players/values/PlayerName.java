package com.buildingblocks.movementsandtactics.domain.players.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PlayerName implements IValueObject {
  private final String name;

  private PlayerName(String name) {
    this.name = name;
  }

  public static PlayerName of(String name){
    return new PlayerName(name);
  }
  @Override
  public void validate() {
      validateNotNull(name, "name cannot be null");
      validateNotEmpty(name, "name cannot be empty");
  }

  public String getName() {
    return name;
  }
}