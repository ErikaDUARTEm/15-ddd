package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class UpdatedMovement extends DomainEvent {
  public UpdatedMovement() {
    super(EventsEnum.UPDATED_MOVEMENT.name());
  }
}
