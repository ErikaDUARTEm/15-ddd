package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class CapturedPiece extends DomainEvent {
  private final String pieceId;

  public CapturedPiece(String pieceId) {
    super(EventsEnum.CAPTURED_PIECE.name());
    this.pieceId = pieceId;
  }

  public String getPieceId() {
    return pieceId;
  }
}
