package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ChangedShift extends DomainEvent {
  public ChangedShift() {
    super(EventsEnum.CHANGED_SHIFT.name());
  }
}
