package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class RecordedMovement extends DomainEvent {
  private final String movementId;

  public RecordedMovement(final String movementId) {
    super(EventsEnum.RECORDED_MOVEMENT.name());
    this.movementId = movementId;
  }

  public String getMovementId() {
    return movementId;
  }
}