package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;

public class CapturedPiece extends DomainEvent {
  private final String opponentPiece;

  public CapturedPiece(String opponentPiece) {
    super(EventsEnum.CAPTURED_PIECE.name());
    this.opponentPiece = opponentPiece;
  }
  public String getOpponentPiece() {
    return opponentPiece;
  }
}