package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;


public class PositionPiece implements IValueObject {
  private final Box positionInitial;
  private final Box positionFinal;

  private PositionPiece(Box positionInitial, Box positionFinal) {
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
    validate();
  }
  public static PositionPiece of(Box positionInitial, Box positionFinal){
    return new PositionPiece(positionInitial, positionFinal);
  }
  @Override
  public void validate() {
    validatePosition(positionInitial);
    validatePosition(positionFinal);
  }
  public static Boolean isPositionValid(Integer fila, String columna) {
    return fila >= 1 && fila <= 8 && columna != null;
  }

  public static void validatePosition(Box position) {
    if (!isPositionValid(position.getRow(), position.getColumn())) {
      throw new IllegalArgumentException("Invalid position: row must be between 1 and 8, and column must be one of A to H");
    }
  }

  public Box getPositionInitial() {
    return positionInitial;
  }

  public Box getPositionFinal() {
    return positionFinal;
  }
}
