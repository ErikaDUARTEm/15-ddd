package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class RuleId extends Identity {
  public RuleId() {
    super();
  }
  private RuleId(String id) {
    super(id);
  }
  public static RuleId of(String id){
    return new RuleId(id);
  }
}
