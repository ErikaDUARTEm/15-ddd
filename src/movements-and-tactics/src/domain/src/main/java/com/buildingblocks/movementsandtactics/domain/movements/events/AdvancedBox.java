package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class AdvancedBox extends DomainEvent {
  private final Integer row;
  private final Integer column;
  private final Integer piece;
  private final Integer idPlayer;

  public AdvancedBox(Integer row, Integer column, Integer piece, Integer idPlayer) {
    super(EventsEnum.ADVANCED_BOX.name());
    this.row = row;
    this.column = column;
    this.piece = piece;
    this.idPlayer = idPlayer;
  }

  public Integer getRow() {
    return row;
  }

  public Integer getColumn() {
    return column;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public Integer getPiece() {
    return piece;
  }
}
