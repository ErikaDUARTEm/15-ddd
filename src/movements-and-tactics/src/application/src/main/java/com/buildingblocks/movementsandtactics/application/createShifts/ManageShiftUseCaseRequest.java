package com.buildingblocks.movementsandtactics.application.createShifts;

import com.buildingblocks.shared.application.Request;

public class ManageShiftUseCaseRequest extends Request {
  private final String playerId;
  private final String shiftId;
  private final String currentShift;

  public ManageShiftUseCaseRequest(String playerId, String shiftId, String currentShift) {
    super(null);
    this.playerId = playerId;
    this.shiftId = shiftId;
    this.currentShift = currentShift;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getShiftId() {
    return shiftId;
  }

  public String getCurrentShift() {
    return currentShift;
  }

}
