package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;

public class UpdatedBox extends DomainEvent {
  private final Integer row;
  private final String column;
  private final String piece;


  public UpdatedBox(Integer row, String column, String piece) {
    super(EventsEnum.UPDATED_BOX.name());
    this.row = row;
    this.column = column;
    this.piece = piece;
  }

  public Integer getRow() {
    return row;
  }

  public String getColumn() {
    return column;
  }

  public String getPiece() {
    return piece;
  }
}
