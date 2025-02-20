package com.buildingblocks.movementsandtactics.domain.jugadores.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class PlayerPiecesId extends Identity {
  public PlayerPiecesId() {
    super();
  }

  private PlayerPiecesId(String id) {
    super(id);
  }

  public static PlayerPiecesId of(String id) {
    return new PlayerPiecesId(id);
  }
}
