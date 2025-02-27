package com.buildingblocks.movementsandtactics.application.shared.movements;

public class ChangeShiftUseCaseResponse {
  private final String movementId;
  private final String playerId;
  private final String shiftId;

  public ChangeShiftUseCaseResponse(String movementId, String playerId, String shiftId) {
    this.movementId = movementId;
    this.playerId = playerId;
    this.shiftId = shiftId;
  }
  public String getShiftId() {
    return shiftId;
  }

  public String getPlayerId(){return playerId;}

  public String getMovementId() {
    return movementId;
  }
}
