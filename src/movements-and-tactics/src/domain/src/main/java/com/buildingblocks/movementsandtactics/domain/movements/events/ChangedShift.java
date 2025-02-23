package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class ChangedShift extends DomainEvent {
  private final String idNewPlayer;
  private final String shiftId;


  public ChangedShift( String idNewPlayer, String shiftId) {
    super(EventsEnum.CHANGED_SHIFT.name());
    this.idNewPlayer = idNewPlayer;
    this.shiftId = shiftId;

  }

  public String getIdNewPlayer() {
    return idNewPlayer;
  }
  public String getShiftId() {
    return shiftId;
  }

}
