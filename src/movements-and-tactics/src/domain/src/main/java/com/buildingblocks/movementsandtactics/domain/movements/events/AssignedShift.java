package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

public class AssignedShift extends DomainEvent {
  private final ShiftId idShift;
  private final Integer idPlayer;
  private final CurrentShift currentShift;

  public AssignedShift(ShiftId idShift, Integer idPlayer, CurrentShift currentShift) {
    super(EventsEnum.ASSIGNED_SHIFT.name());
    this.idShift = idShift;
    this.idPlayer = idPlayer;
    this.currentShift = currentShift;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public ShiftId getIdShift() {
    return idShift;
  }

  public CurrentShift getCurrentShift() {
    return currentShift;
  }
}
