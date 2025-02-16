package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class InvalidMovement extends DomainEvent {
  public InvalidMovement() {
    super(EventsEnum.INVALID_MOVEMENT.name());
  }
}
