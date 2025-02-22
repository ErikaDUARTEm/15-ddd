package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class PlayerWonGame extends DomainEvent {
  private final String playerId;
  private final String name;

  public PlayerWonGame( String playerId, String name1) {
    super(EventsEnum.PLAYER_WON_GAME.name());
    this.playerId = playerId;
    this.name = name1;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getName() {
    return name;
  }
}