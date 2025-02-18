package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

public class ChangedShift extends DomainEvent {
  private final Integer idPreviousPlayer;
  private final Integer idNewPlayer;
  private final ShiftId shiftId;

  public ChangedShift(Integer idPreviousPlayer, Integer idNewPlayer, ShiftId shiftId) {
    super(EventsEnum.CHANGED_SHIFT.name());
    this.idPreviousPlayer = idPreviousPlayer;
    this.idNewPlayer = idNewPlayer;
    this.shiftId = shiftId;
  }

  public Integer getIdPreviousPlayer() {
    return idPreviousPlayer;
  }

  public Integer getIdNewPlayer() {
    return idNewPlayer;
  }
  public ShiftId getShiftId() {
    return shiftId;
  }

}
