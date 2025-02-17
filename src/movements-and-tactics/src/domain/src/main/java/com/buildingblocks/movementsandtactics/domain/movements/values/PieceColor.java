package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

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
  public List<String> validate() {
    validateNotNull(color, "color cannot be null");
    validateNotEmpty(color, "color cannot be empty");
    validateColor(color);
    return null;
  }

  public String getColor() {
    return color;
  }
}
