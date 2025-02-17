package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;


public class TypeId extends Identity{
  public TypeId() {
    super();
  }
  private TypeId(String id) {
    super(id);
  }
  public static TypeId of(String id){
    return new TypeId(id);
  }
}
