package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColor;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColorNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColorNotNull;

public class PieceColor implements IValueObject {
  private final String color;

  private PieceColor(String color) {
    this.color = color;
  }
  public static PieceColor of(String color){
    return new PieceColor(color);
  }

  @Override
  public void validate() {
    validateColorNotNull(color);
    validateColorNotEmpty(color);
    validateColor(color);
  }

  public String getColor() {
    return color;
  }
}
