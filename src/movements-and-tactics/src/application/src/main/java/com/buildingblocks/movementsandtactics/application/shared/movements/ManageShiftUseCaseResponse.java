package com.buildingblocks.movementsandtactics.application.shared.movements;

public class ManageShiftUseCaseResponse {
  private final String playerId;
  private final String shiftId;
  private final String currentShift;


  public ManageShiftUseCaseResponse( String playerId, String shiftId,String currentShift) {
    this.playerId = playerId;
    this.shiftId = shiftId;
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


}

