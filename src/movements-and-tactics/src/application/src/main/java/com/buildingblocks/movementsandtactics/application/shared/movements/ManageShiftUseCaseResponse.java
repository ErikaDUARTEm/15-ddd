package com.buildingblocks.movementsandtactics.application.shared.movements;

public class ManageShiftUseCaseResponse {
  private final String movementId;
  private final String shiftId;
  private final String playerId;
  private final String currentShift;


  public ManageShiftUseCaseResponse(String movementId, String shiftId, String playerId, String currentShift) {
    this.movementId = movementId;
    this.shiftId = shiftId;
    this.playerId = playerId;
    this.currentShift = currentShift;

  }

  public String getShiftId() {
    return shiftId;
  }

  public String getPlayerId() {
    return playerId;
  }

  public String getCurrentShift() {
    return currentShift;
  }

  public String getMovementId() {
    return movementId;
  }
}

