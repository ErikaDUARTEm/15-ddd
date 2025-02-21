package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerStatisticsId;

public class PlayerStatistics extends Entity<PlayerStatisticsId> {
  private Integer gamesPlayed;
  private Integer winCount;
  private Integer lossCount;

  //region Constructors
  public PlayerStatistics(PlayerStatisticsId identity, Integer gamesPlayed, Integer winCount, Integer lossCount) {
    super(identity);
    this.gamesPlayed = gamesPlayed;
    this.winCount = winCount;
    this.lossCount = lossCount;
  }
  public PlayerStatistics( ){
    super(new PlayerStatisticsId());
    this.gamesPlayed = 0;
    this.winCount = 0;
    this.lossCount = 0;
  }
  //endregion
  //region Getters and Setters

  public Integer getGamesPlayed() {
    return gamesPlayed;
  }

  public void setGamesPlayed(Integer gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  public Integer getWinCount() {
    return winCount;
  }

  public void setWinCount(Integer winCount) {
    this.winCount = winCount;
  }

  public Integer getLossCount() {
    return lossCount;
  }

  public void setLossCount(Integer lossCount) {
    this.lossCount = lossCount;
  }

  //endregion
  //region Methods

  public double getWinRate() {
    return gamesPlayed == 0 ? 0 : (double) winCount / gamesPlayed;
  }

  //endregion
}


