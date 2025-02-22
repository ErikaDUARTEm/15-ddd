package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class AddedPiece extends DomainEvent {
  private final String Color;
  private final String Type;

  public AddedPiece( String color, String type) {
    super(EventsEnum.ADDED_PIECE.name());
    Color = color;
    Type = type;
  }

  public String getColor() {
    return Color;
  }

  public String getType() {
    return Type;
  }
}
