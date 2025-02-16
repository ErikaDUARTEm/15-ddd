package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class RecordedMovement extends DomainEvent {
  public RecordedMovement() {
    super(EventsEnum.RECORDED_MOVEMENT.name());
  }
}
