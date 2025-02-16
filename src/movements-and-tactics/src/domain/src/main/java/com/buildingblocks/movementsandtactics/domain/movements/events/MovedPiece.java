package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class MovedPiece extends DomainEvent {
  public MovedPiece() {
    super(EventsEnum.MOVED_PIECE.name());
  }
}
