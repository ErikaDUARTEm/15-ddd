package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class UpdatedMovement extends DomainEvent {
  private final Integer idMovement;
  private final Integer idPlayer;
  private final PositionPiece positionInitial;
  private final PositionPiece positionFinal;
  private final PieceType pieceType;
  private final PieceColor pieceColor;

  public UpdatedMovement(Integer idMovement, Integer idPlayer, PositionPiece positionInitial, PositionPiece positionFinal, PieceType pieceType, PieceColor pieceColor) {
    super(EventsEnum.UPDATED_MOVEMENT.name());
    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.positionInitial = positionInitial;
    this.positionFinal = positionFinal;
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
  }

  public Integer getIdMovement() {
    return idMovement;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public PositionPiece getPositionInitial() {
    return positionInitial;
  }

  public PositionPiece getPositionFinal() {
    return positionFinal;
  }

  public PieceType getPieceType() {
    return pieceType;
  }

  public PieceColor getPieceColor() {
    return pieceColor;
  }
}
