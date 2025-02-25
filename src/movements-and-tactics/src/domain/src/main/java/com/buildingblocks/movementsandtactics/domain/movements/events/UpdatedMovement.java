package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class UpdatedMovement extends DomainEvent {
  private final String idMovement;
  private final String idPlayer;
  private final Integer row;
  private final String column;
  private final String pieceId;

  public UpdatedMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId) {
    super(EventsEnum.UPDATED_MOVEMENT.name());

    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
  }

  public String getIdMovement() {
    return idMovement;
  }

  public Integer getRow() {
    return row;
  }

  public String getIdPlayer() {
    return idPlayer;
  }

  public String getColumn() {
    return column;
  }

  public String getPieceId() {
    return pieceId;
  }
}
