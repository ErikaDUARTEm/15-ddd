package com.buildingblocks.movementsandtactics.application.shared.movements;

public class ChangeShiftUseCaseResponse {

  private final String shiftId;
  private final String playerId;

  public ChangeShiftUseCaseResponse(String shiftId, String playerId) {
    this.shiftId = shiftId;
    this.playerId = playerId;
  }
  public String getShiftId() {
    return shiftId;
  }

  public String getPlayerId() {
    return playerId;
  }
}
