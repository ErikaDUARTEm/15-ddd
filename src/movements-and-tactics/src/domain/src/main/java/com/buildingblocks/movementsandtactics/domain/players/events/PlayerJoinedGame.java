package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class PlayerJoinedGame extends DomainEvent {
  private final String playerId;
  private final String gameId;


  public PlayerJoinedGame(String playerId, String gameId) {
    super(EventsEnum.PLAYER_JOINED_GAME.name());
    this.playerId = playerId;
    this.gameId = gameId;
  }

  public String getPlayerId() {
    return playerId;
  }
  public String getGameId() {
    return gameId;
  }

}
