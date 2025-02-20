package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class ChangedShift extends DomainEvent {
  private final String idPreviousPlayer;
  private final String idNewPlayer;
  private final String shiftId;
  private final String currentShiftId;

  public ChangedShift(String idPreviousPlayer, String idNewPlayer, String shiftId, String currentShiftId) {
    super(EventsEnum.CHANGED_SHIFT.name());
    this.idPreviousPlayer = idPreviousPlayer;
    this.idNewPlayer = idNewPlayer;
    this.shiftId = shiftId;
    this.currentShiftId = currentShiftId;
  }

  public String getIdPreviousPlayer() {
    return idPreviousPlayer;
  }

  public String getIdNewPlayer() {
    return idNewPlayer;
  }
  public String getShiftId() {
    return shiftId;
  }
  public String getCurrentShiftId() {
    return currentShiftId;
  }

}
