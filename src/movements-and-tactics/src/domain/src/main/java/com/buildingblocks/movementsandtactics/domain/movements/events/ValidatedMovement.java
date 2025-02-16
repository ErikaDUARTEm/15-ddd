package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.movements.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ValidatedMovement extends DomainEvent {
  private final Integer idMovement;
  private final  Integer idPlayer;
  private final PositionPiece positionPiece;
  private final PieceType pieceType;
  private final PieceColor pieceColor;

  public ValidatedMovement(Integer idMovement, Integer idPlayer, PositionPiece positionPiece, PieceType pieceType, PieceColor pieceColor) {
    super(EventsEnum.VALIDATED_MOVEMENT.name());
    this.idMovement = idMovement;
    this.idPlayer = idPlayer;
    this.positionPiece = positionPiece;
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
  }

  public Integer getIdMovement() {
    return idMovement;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public PositionPiece getPositionPiece() {
    return positionPiece;
  }

  public PieceType getPieceType() {
    return pieceType;
  }

  public PieceColor getPieceColor() {
    return pieceColor;
  }
}
