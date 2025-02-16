package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ExecutedMovement extends DomainEvent {
  public ExecutedMovement() {
    super(EventsEnum.EXECUTED_MOVEMENT.name());
  }
}
