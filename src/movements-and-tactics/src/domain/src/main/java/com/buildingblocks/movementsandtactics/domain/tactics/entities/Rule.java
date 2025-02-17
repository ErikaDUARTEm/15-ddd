package com.buildingblocks.movementsandtactics.domain.tactics.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.tactics.values.Description;
import com.buildingblocks.movementsandtactics.domain.tactics.values.GeneralConditions;
import com.buildingblocks.movementsandtactics.domain.tactics.values.RuleId;

public class Rule extends Entity<RuleId> {
  private Description description;
  private GeneralConditions generalConditions;

  //region Constructors
  public Rule(RuleId identity, Description description, GeneralConditions generalConditions) {
    super(identity);
    this.description = description;
    this.generalConditions = generalConditions;
  }
  public Rule(Description description, GeneralConditions generalConditions) {
    super(new RuleId());
    this.description = description;
    this.generalConditions = generalConditions;
  }
//endregion
  //region Getters and Setters
  public GeneralConditions getGeneralConditions() {
    return generalConditions;
  }

  public void setGeneralConditions(GeneralConditions generalConditions) {
    this.generalConditions = generalConditions;
  }

  public Description getDescription() {
    return description;
  }

  public void setDescription(Description description) {
    this.description = description;
  }
  //endregion
  //region Methods

  //endregion
}
