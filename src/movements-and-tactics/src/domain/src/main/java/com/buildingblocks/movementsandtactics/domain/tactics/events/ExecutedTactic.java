package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ExecutedTactic extends DomainEvent {
  public ExecutedTactic() {
    super(EventsEnum.EXECUTED_TACTIC.name());
  }
}
