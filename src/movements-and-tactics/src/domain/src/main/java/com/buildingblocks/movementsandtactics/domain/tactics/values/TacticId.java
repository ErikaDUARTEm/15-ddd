package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class TacticId extends Identity {
  public TacticId() {
    super();
  }
  private TacticId(String id) {
    super(id);
  }
  public static TacticId of(String id){
    return new TacticId(id);
  }
}
