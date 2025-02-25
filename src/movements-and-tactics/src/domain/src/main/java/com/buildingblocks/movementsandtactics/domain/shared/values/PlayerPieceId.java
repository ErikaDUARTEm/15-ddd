package com.buildingblocks.movementsandtactics.domain.shared.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class PlayerPieceId extends Identity {
  public PlayerPieceId() {
    super();
  }

  private PlayerPieceId(String id) {
    super(id);
  }

  public static PlayerPieceId of(String id) {
    return new PlayerPieceId(id);
  }
}
