package com.buildingblocks.movementsandtactics.application.changeShift;

import com.buildingblocks.shared.application.Request;

public class ChangeShiftUseCaseRequest extends Request {
  private String playerId;
  private String shiftId;


  public ChangeShiftUseCaseRequest(String aggregateId, String playerId, String shiftId) {
    super(aggregateId);
    this.playerId = playerId;
    this.shiftId = shiftId;
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
