package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class PartTypeValidated extends DomainEvent {
  public PartTypeValidated() {
    super(EventsEnum.PART_TYPE_VALIDATED.name());
  }
}
