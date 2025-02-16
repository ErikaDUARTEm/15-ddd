package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ShiftRegistered extends DomainEvent {
  public ShiftRegistered() {
    super(EventsEnum.SHIFT_REGISTERED.name());
  }
}
