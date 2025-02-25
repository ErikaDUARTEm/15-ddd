package com.buildingblocks.movementsandtactics.application.shared.movements;

public class ManageShiftUseCaseResponse {
  private final String shiftId;
  private final String playerId;
  private final String currentShift;


  public ManageShiftUseCaseResponse( String shiftId,String playerId,String currentShift) {
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


}

