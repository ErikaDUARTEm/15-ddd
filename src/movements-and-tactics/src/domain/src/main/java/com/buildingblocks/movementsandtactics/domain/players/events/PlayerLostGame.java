package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class PlayerLostGame extends DomainEvent {
  private final String playerId;
  private final String namePlayer;


  public PlayerLostGame( String playerId, String namePlayer) {
    super(EventsEnum.PLAYER_LOST_GAME.name());
    this.playerId = playerId;
    this.namePlayer = namePlayer;
  }

  public String getPlayerId() {
    return playerId;
  }
  public String getNamePlayer() {
    return namePlayer;
  }
}
