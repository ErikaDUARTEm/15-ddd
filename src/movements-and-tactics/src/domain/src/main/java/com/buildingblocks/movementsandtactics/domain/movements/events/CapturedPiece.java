package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;

public class CapturedPiece extends DomainEvent {
  private final PieceMovement opponentPiece;

  public CapturedPiece(PieceMovement opponentPiece) {
    super(EventsEnum.CAPTUREDPIECE.name());
    this.opponentPiece = opponentPiece;
  }
  public PieceMovement getOpponentPiece() {
    return opponentPiece;
  }
}