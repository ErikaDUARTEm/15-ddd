package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class EndedShift extends DomainEvent {

  public EndedShift() {
    super(EventsEnum.ENDED_SHIFT.name());
  }

}
