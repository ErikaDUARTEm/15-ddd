package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.utils.Column;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class AdvancedBox extends DomainEvent {
  private final Integer row;
  private final String column;
  private final String pieceId;
  private final String idPlayer;

  public AdvancedBox(Integer row, String column, String pieceId, String idPlayer) {
    super(EventsEnum.ADVANCED_BOX.name());
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
    this.idPlayer = idPlayer;
  }

  public Integer getRow() {
    return row;
  }

  public String getColumn() {
    return column;
  }

  public String getIdPlayer() {
    return idPlayer;
  }

  public String getPieceId() {
    return pieceId;
  }
}
