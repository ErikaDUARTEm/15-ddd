package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class CurrentShift implements IValueObject {
  private final String shiftId;
  private final String playerId;

  private CurrentShift(String shiftId, String playerId) {
    this.shiftId = shiftId;
    this.playerId = playerId;
    validate();
  }
  public static CurrentShift of(String shiftId, String playerId){
    return new CurrentShift(shiftId, playerId);
  }
  @Override
  public void validate() {
    validateNotNull(shiftId, "numberShift cannot be null");
  }

  public String getNumberShift() {
    return shiftId;
  }
  public String getPlayerId() {
    return playerId;
  }

}
