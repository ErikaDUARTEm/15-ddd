package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColor;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceColor implements IValueObject {
  private final String color;

  private PieceColor(String color) {
    this.color = color;
    validate();
  }
  public static PieceColor of(String color){
    return new PieceColor(color);
  }

  @Override
  public void validate() {
    validateNotNull(color, "color cannot be null");
    validateNotEmpty(color, "color cannot be empty");
    validateColor(color);
  }

  public String getColor() {
    return color;
  }
}
