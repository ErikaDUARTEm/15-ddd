package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.Identity;

public class BoardStatusId extends Identity {
  public BoardStatusId() {
    super();
  }
  private BoardStatusId(String id) {
    super(id);
  }
  public static BoardStatusId of(String id){
    return new BoardStatusId(id);
  }
}
