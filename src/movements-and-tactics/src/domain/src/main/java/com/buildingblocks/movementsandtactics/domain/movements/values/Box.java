package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.ValidateBoxes.validateColumn;
import static com.buildingblocks.domain.shared.domain.utils.ValidateBoxes.validateRow;

public class Box implements IValueObject {
  private final Integer row;
  private final Column column;
  private final Integer pieceId;

  private Box(final Integer row, final Column column, final Integer pieceId) {
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
    validate();
  }
  public static Box of(Integer row, Column column, Integer pieceId){
    return new Box(row, column, pieceId);
  }

  @Override
  public void validate() {
    validateRow(row);
    validateColumn(column);
  }
  public boolean isOccupiedBox() {
    return pieceId != null;
  }
  public Integer getRow() {
    return row;
  }

  public Column getColumn() {
    return column;
  }

  public Integer getPiece() {
    return pieceId;
  }
}
