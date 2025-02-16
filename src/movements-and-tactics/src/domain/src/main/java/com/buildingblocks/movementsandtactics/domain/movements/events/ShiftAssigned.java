package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ShiftAssigned extends DomainEvent {
  public ShiftAssigned() {
    super(EventsEnum.SHIFT_ASSIGNED.name());
  }
}
