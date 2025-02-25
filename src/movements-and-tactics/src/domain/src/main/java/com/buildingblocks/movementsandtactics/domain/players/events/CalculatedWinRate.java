package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class CalculatedWinRate extends DomainEvent {
  private final String playerId;
  private final Double winRate;

  public CalculatedWinRate(String playerId) {
    super(EventsEnum.UPDATED_WIN_RATE.name());
    this.playerId = playerId;
    this.winRate = 0.0;
  }

  public Double getWinRate() {
    return winRate;
  }

  public String getPlayerId() {
    return playerId;
  }
}