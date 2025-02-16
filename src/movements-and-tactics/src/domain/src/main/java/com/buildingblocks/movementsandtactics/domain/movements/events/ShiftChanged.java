package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ShiftChanged extends DomainEvent {
  public ShiftChanged() {
    super(EventsEnum.SHIFT_CHANGED.name());
  }
}
