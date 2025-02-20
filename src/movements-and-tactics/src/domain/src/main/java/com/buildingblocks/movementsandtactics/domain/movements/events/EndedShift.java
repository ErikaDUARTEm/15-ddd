package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class EndedShift extends DomainEvent {
  private final String playerId;

  public EndedShift(String playerId) {
    super(EventsEnum.ENDED_SHIFT.name());
    this.playerId = playerId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
