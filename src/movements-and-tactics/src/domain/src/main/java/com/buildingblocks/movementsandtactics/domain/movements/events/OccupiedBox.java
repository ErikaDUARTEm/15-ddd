package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class OccupiedBox extends DomainEvent {
  public OccupiedBox() {
    super(EventsEnum.OCCUPIED_BOX.name());
  }
}
