package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class AdvancedBox extends DomainEvent {
  public AdvancedBox() {
    super(EventsEnum.ADVANCED_BOX.name());
  }
}
