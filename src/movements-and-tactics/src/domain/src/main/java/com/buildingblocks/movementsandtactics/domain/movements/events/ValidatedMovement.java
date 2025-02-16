package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ValidatedMovement extends DomainEvent {
  public ValidatedMovement() {
    super(EventsEnum.VALIDATED_MOVEMENT.name());
  }
}
