package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.ValidateBoxes.validateColumn;
import static com.buildingblocks.domain.shared.domain.utils.ValidateBoxes.validateRow;

public class Boxes implements IValueObject {
  private final Integer row;
  private final Column column;
  private final PieceMovement piece;

  private Boxes(final Integer row, final Column column,final PieceMovement piece) {
    this.row = row;
    this.column = column;
    this.piece = piece;
    validate();
  }
  public static Boxes of(Integer row, Column column, PieceMovement piece){
    return new Boxes(row, column, piece);
  }

  @Override
  public void validate() {
    validateRow(row);
    validateColumn(column);
  }

  public Integer getRow() {
    return row;
  }

  public Column getColumn() {
    return column;
  }

  public PieceMovement getPiece() {
    return piece;
  }
}
