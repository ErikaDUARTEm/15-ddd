package com.buildingblocks.movementsandtactics.domain.shared.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class PlayerId extends Identity {
  public PlayerId() {
    super();
  }

  private PlayerId(String id) {
    super(id);
  }

  public static PlayerId of(String id) {
    return new PlayerId(id);
  }
}