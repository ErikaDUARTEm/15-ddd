package com.buildingblocks.movementsandtactics.domain.players.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class AddedPiece extends DomainEvent {
  private final String playerId;
  private final String name;


  public AddedPiece( String playerId, String name1) {
    super(EventsEnum.PLAYER_LOST_GAME.name());
    this.playerId = playerId;
    this.name = name1;
  }

  public String getPlayerId() {
    return playerId;
  }

  @Override
  public String getName() {
    return name;
  }
}
