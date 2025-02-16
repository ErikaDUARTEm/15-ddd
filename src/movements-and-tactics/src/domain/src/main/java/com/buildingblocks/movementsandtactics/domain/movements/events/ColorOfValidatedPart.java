package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ColorOfValidatedPart extends DomainEvent {
  public ColorOfValidatedPart() {
    super(EventsEnum.COLOR_OF_VALIDATED_PART.name());
  }
}
