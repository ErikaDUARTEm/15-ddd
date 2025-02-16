package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class UnoccupiedBox extends DomainEvent {
  public UnoccupiedBox() {
    super(EventsEnum.UNOCCUPIED_BOX.name());
  }
}
