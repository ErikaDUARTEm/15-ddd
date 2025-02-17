package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.domain.shared.domain.utils.Column;


public class PositionPiece implements IValueObject {
  private final Boxes positionInitial;
  private final Boxes positionFinal;

  private PositionPiece(Boxes positionInitial, Boxes positionFinal) {
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
    validate();
  }
  public static PositionPiece of(Boxes positionInitial, Boxes positionFinal){
    return new PositionPiece(positionInitial, positionFinal);
  }
  @Override
  public void validate() {
    validatePosition(positionInitial);
    validatePosition(positionFinal);
  }
  public static Boolean isPositionValid(Integer fila, Column columna) {
    return fila >= 1 && fila <= 8 && columna != null;
  }

  public static void validatePosition(Boxes position) {
    if (!isPositionValid(position.getRow(), position.getColumn())) {
      throw new IllegalArgumentException("Invalid position: row must be between 1 and 8, and column must be one of A to H");
    }
  }

  public Boxes getPositionInitial() {
    return positionInitial;
  }

  public Boxes getPositionFinal() {
    return positionFinal;
  }
}
