package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerStatistics;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerId;


public class Player extends AggregateRoot<PlayerId> {
  private String name;
  private String colorPiece;
  private PlayerStatistics statistics;


  //region Constructor
  public Player() {
    super(new PlayerId());
    subscribe(new PlayerHandler(this));
  }
  private Player(PlayerId identity) {
    super(identity);
  }


  //endregion

//region Getters and Setters
public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public String getColorPiece() {
  return colorPiece;
}

public void setColorPiece(String colorPiece) {
  this.colorPiece = colorPiece;
}

public PlayerStatistics getStatistics() {
  return statistics;
}

public void setStatistics(PlayerStatistics statistics) {
  this.statistics = statistics;
}
//endregion

//region Methods
//endregion
}