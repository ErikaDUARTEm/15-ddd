package com.buildingblocks.movementsandtactics.domain.shared.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.domain.shared.domain.utils.Color;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColor;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceColor implements IValueObject {
  private final Color color;

  private PieceColor(Color color) {
    this.color = color;
    validate();
  }
  public static PieceColor of(Color color){
    return new PieceColor(color);
  }

  @Override
  public void validate() {
    validateNotNull(color, "color cannot be null");
    validateNotEmpty(String.valueOf(color), "color cannot be empty");
    validateColor(String.valueOf(color));
  }

  public Color getColor() {
    return color;
  }
}
