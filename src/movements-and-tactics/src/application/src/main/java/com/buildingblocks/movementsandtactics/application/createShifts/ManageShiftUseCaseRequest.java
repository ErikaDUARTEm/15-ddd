package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.shared.application.Request;

public class ManageShiftUseCaseRequest extends Request {
  private String playerId;
  private String currentShift;

  public ManageShiftUseCaseRequest( String aggregateId, String playerId, String currentShift) {
    super(aggregateId);
    this.playerId = playerId;
    this.currentShift = currentShift;
  }
  public ManageShiftUseCaseRequest(){}
  public String getPlayerId() {
    return playerId;
  }

  public String getCurrentShift() {
    return currentShift;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

  public void setCurrentShift(String currentShift) {
    this.currentShift = currentShift;
  }
}
