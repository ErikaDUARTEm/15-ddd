package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ExecutedMovement extends DomainEvent {
  private final Integer idMovement;
  private final Integer idPlayer;
  private final Integer idPiece;
  private final PositionPiece positionInitial;
  private final PositionPiece positionFinal;

  public ExecutedMovement(Integer idMovement, Integer idPlayer, Integer idPiece, PositionPiece positionInitial, PositionPiece positionFinal) {
    super(EventsEnum.EXECUTED_MOVEMENT.name());
    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.idPiece = idPiece;
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
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
}
