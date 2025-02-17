package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class UpdatedBox extends DomainEvent {
  private final Integer row;
  private final Column column;
  private final PieceMovement piece;


  public UpdatedBox(Integer row, Column column, PieceMovement piece) {
    super(EventsEnum.UPDATED_BOX.name());
    this.row = row;
    this.column = column;
    this.piece = piece;
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
