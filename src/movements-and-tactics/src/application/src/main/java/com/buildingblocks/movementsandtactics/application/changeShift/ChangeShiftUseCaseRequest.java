package com.buildingblocks.movementsandtactics.application.changeShift;

import com.buildingblocks.shared.application.Request;

public class ChangeShiftUseCaseRequest extends Request {
  private String shiftId;
  private String playerId;


  public ChangeShiftUseCaseRequest(String aggregateId, String shiftId, String playerId) {
    super(aggregateId);
    this.shiftId = shiftId;
    this.playerId = playerId;
  }
  public ChangeShiftUseCaseRequest(){}
  public String getPlayerId() {
    return playerId;
  }

  public String getShiftId() {
    return shiftId;
  }

  public void setShiftId(String shiftId) {
    this.shiftId = shiftId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }
}
