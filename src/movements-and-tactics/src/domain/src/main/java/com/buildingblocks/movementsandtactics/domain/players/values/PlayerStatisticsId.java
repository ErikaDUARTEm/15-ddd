package com.buildingblocks.movementsandtactics.domain.jugadores.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class PlayerStatisticsId extends Identity {
  public PlayerStatisticsId() {
    super();
  }

  private PlayerStatisticsId(String id) {
    super(id);
  }

  public static PlayerStatisticsId of(String id) {
    return new PlayerStatisticsId(id);
  }
}
