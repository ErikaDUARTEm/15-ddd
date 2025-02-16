package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class CurrentShiftChecked extends DomainEvent {
  public CurrentShiftChecked() {
    super(EventsEnum.CURRENT_SHIFT_CHECKED.name());
  }
}
