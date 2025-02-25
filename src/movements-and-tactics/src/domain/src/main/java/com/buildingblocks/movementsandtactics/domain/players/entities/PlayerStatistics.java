package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerStatisticsId;

public class PlayerStatistics extends Entity<PlayerStatisticsId> {
  private Integer gamesPlayed;
  private Integer winCount;
  private Integer lossCount;
  private Double winRate;

  //region Constructors
  public PlayerStatistics(PlayerStatisticsId identity, Integer gamesPlayed, Integer winCount, Integer lossCount, Double winRate) {
    super(identity);
    this.gamesPlayed = gamesPlayed;
    this.winCount = winCount;
    this.lossCount = lossCount;
    this.winRate = winRate;
  }
  public PlayerStatistics(){
    super(new PlayerStatisticsId());
    this.winRate = 0.0;
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
  public Double getWinRate() {
    return winRate;
  }

  public void setWinRate(Double winRate) {
    this.winRate = winRate;
  }

  //endregion
  //region Methods

  public double calculateWinRate() {
    return gamesPlayed == 0 ? 0 : (double) winCount / gamesPlayed;
  }

  //endregion
}


