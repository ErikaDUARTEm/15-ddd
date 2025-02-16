package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class UpdatedBox extends DomainEvent {
  public UpdatedBox() {
    super(EventsEnum.UPDATED_BOX.name());
  }
}
