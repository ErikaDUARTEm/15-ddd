package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class InvalidMovement extends DomainEvent {
  private final String idMovement;
  private final String idPlayer;
  private final Integer row;
  private final String column;
  private final String pieceId;
  private final String reason;

  public InvalidMovement(String idMovement, String idPlayer,Integer row, String column, String pieceId, String reason) {
    super(EventsEnum.INVALID_MOVEMENT.name());
    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
    this.reason = reason;
  }

  public String getIdMovement() {
    return idMovement;
  }

  public String getIdPlayer() {
    return idPlayer;
  }


  public String getReason() {
    return reason;
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
