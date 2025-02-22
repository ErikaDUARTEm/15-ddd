package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class RemovedPiece extends DomainEvent {
  private final String pieceId;
  private final String color;
  private final String type;

  public RemovedPiece(String pieceId, String color, String type) {
    super(EventsEnum.REMOVED_PIECE.name());
    this.pieceId = pieceId;
    this.color = color;
    this.type = type;
  }
  public String getPieceId() {
    return pieceId;
  }

  public String getColor() {
    return color;
  }

  public String getType() {
    return type;
  }
}
