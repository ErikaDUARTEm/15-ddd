package com.buildingblocks.movementsandtactics.domain.tactics.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.tactics.values.Description;
import com.buildingblocks.movementsandtactics.domain.tactics.values.Name;
import com.buildingblocks.movementsandtactics.domain.tactics.values.PiecesInvolved;
import com.buildingblocks.movementsandtactics.domain.tactics.values.SpecificConditions;
import com.buildingblocks.movementsandtactics.domain.tactics.values.TypeId;

public class Type extends Entity<TypeId> {
  private Name name;
  private Description description;
  private SpecificConditions specificConditions;
  private PiecesInvolved piecesInvolved;

  //region Constructors
  public Type(TypeId identity, Name name, Description description, SpecificConditions specificConditions, PiecesInvolved piecesInvolved) {
    super(identity);
    this.name = name;
    this.description = description;
    this.specificConditions = specificConditions;
    this.piecesInvolved = piecesInvolved;
  }
  public Type(Name name, Description description, SpecificConditions specificConditions, PiecesInvolved piecesInvolved) {
    super(new TypeId());
    this.name = name;
    this.description = description;
    this.specificConditions = specificConditions;
    this.piecesInvolved = piecesInvolved;
  }

//endregion
//region Getters and Setters

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Description getDescription() {
    return description;
  }

  public void setDescription(Description description) {
    this.description = description;
  }

  public SpecificConditions getSpecificConditions() {
    return specificConditions;
  }

  public void setSpecificConditions(SpecificConditions specificConditions) {
    this.specificConditions = specificConditions;
  }

  public PiecesInvolved getPiecesInvolved() {
    return piecesInvolved;
  }

  public void setPiecesInvolved(PiecesInvolved piecesInvolved) {
    this.piecesInvolved = piecesInvolved;
  }
//endregion
//region Methods

//endregion

}
