package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class AdvancedBox extends DomainEvent {
  private final Integer row;
  private final Column column;
  private final String piece;
  private final Integer idPlayer;

  public AdvancedBox(Integer row, Column column, String piece, Integer idPlayer) {
    super(EventsEnum.ADVANCED_BOX.name());
    this.row = row;
    this.column = column;
    this.piece = piece;
    this.idPlayer = idPlayer;
  }

  public Integer getRow() {
    return row;
  }

  public Column getColumn() {
    return column;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public String getPiece() {
    return piece;
  }
}
