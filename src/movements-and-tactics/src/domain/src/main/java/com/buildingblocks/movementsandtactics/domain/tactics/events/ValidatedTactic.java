package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ValidatedTactic extends DomainEvent {
  public ValidatedTactic() {
    super(EventsEnum.VALIDATED_TACTIC.name());
  }
}
