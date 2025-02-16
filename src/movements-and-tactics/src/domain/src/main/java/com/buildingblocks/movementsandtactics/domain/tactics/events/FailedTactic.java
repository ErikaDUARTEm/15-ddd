package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class FailedTactic extends DomainEvent {
  public FailedTactic() {
    super(EventsEnum.FAILED_TACTIC.name());
  }
}
