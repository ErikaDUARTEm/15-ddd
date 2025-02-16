package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class DescribedTactic extends DomainEvent {
  public DescribedTactic() {
    super(EventsEnum.DESCRIBED_TACTIC.name());
  }
}
