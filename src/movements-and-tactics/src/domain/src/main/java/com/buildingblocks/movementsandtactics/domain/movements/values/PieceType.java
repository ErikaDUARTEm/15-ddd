package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceType implements IValueObject {
  private final Type type;

  private PieceType(Type type) {
    this.type = type;

  }
  public static PieceType of(Type type){
    return new PieceType(type);
  }

  @Override
  public void validate() {
    validateNotNull(String.valueOf(type));
    validateNotEmpty(String.valueOf(type));
  }

  public Type getType() {
    return type;
  }
}
