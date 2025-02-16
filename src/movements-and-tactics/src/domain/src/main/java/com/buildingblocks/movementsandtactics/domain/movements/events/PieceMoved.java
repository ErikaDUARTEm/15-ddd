package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class PieceMoved extends DomainEvent {
  public PieceMoved() {
    super(EventsEnum.PIECE_MOVED.name());
  }
}
