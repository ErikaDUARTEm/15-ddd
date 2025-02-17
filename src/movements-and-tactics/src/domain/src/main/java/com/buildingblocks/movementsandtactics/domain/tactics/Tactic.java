package com.buildingblocks.movementsandtactics.domain.tactics;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.tactics.entities.Rule;
import com.buildingblocks.movementsandtactics.domain.tactics.entities.Type;
import com.buildingblocks.movementsandtactics.domain.tactics.values.TacticId;

public class Tactic extends AggregateRoot<TacticId> {
  private Type type;
  private Rule rule;

  //region Constructors
  public Tactic() {
    super(new TacticId());
  }
  private Tactic(TacticId identity) {
    super(identity);
  }

  //endregion
  //region Getters and Setters
  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Rule getRule() {
    return rule;
  }

  public void setRule(Rule rule) {
    this.rule = rule;
  }
  //endregion
  //region Methods
  //endregion
}
