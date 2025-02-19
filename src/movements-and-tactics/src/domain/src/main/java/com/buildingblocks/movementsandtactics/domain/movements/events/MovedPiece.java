package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.domain.shared.domain.utils.Column;

public class MovedPiece extends DomainEvent {
  private final String idPlayer;
  private final String pieceId;
  private final Integer row;
  private final String column;

  public MovedPiece(String idPlayer, String pieceId, Integer row, String column) {
    super(EventsEnum.MOVED_PIECE.name());
    this.idPlayer = idPlayer;
    this.pieceId = pieceId;
    this.row = row;
    this.column = column;
  }

  public String getIdPlayer() {
    return idPlayer;
  }

  public String getPieceId() {
    return pieceId;
  }
  public String getColumn() {
    return column;
  }

  public Integer getRow() {
    return row;
  }


}
