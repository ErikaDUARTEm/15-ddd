package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ExecutedMovement extends DomainEvent {
  private final String idMovement;
  private final String idPlayer;
  private final Integer row;
  private final String column;
  private final String pieceId;

  public ExecutedMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId) {
    super(EventsEnum.EXECUTED_MOVEMENT.name());

    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;

  }

  public String getIdMovement() {
    return idMovement;
  }

  public String getIdPlayer() {
    return idPlayer;
  }

  public Integer getRow() {
    return row;
  }

  public String getColumn() {
    return column;
  }

  public String getPieceId() {
    return pieceId;
  }
}