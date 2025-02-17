package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class InvalidMovement extends DomainEvent {
  private final Integer idMovement;
  private final Integer idPlayer;
  private final Integer idPiece;
  private final PositionPiece positionInitial;
  private final PositionPiece positionFinal;
  private final String reason;

  public InvalidMovement(Integer idMovement, Integer idPlayer, Integer idPiece, PositionPiece positionInitial, PositionPiece positionFinal, String reason) {
    super(EventsEnum.INVALID_MOVEMENT.name());
    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.idPiece = idPiece;
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
    this.reason = reason;
  }

  public Integer getIdMovement() {
    return idMovement;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public Integer getIdPiece() {
    return idPiece;
  }

  public PositionPiece getPositionInitial() {
    return positionInitial;
  }

  public PositionPiece getPositionFinal() {
    return positionFinal;
  }

  public String getReason() {
    return reason;
  }
}
