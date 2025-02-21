package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class GameEnded extends DomainEvent {
  private final String winnerId;
  private final String loserId;

  public GameEnded(String winnerId, String loserId) {
    super(EventsEnum.EXECUTED_MOVEMENT.name());
    this.winnerId = winnerId;
    this.loserId = loserId;
  }

  public String getWinnerId() {
    return winnerId;
  }

  public String getLoserId() {
    return loserId;
  }
}
