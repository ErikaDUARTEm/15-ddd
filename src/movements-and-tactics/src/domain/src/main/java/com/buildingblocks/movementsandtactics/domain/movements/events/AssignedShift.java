package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class AssignedShift extends DomainEvent {
  private final String idPlayer;
  private final String currentShift;

  public AssignedShift(String idPlayer, String currentShift) {
    super(EventsEnum.ASSIGNED_SHIFT.name());
    this.idPlayer = idPlayer;
    this.currentShift = currentShift;
  }

  public String getIdPlayer() {
    return idPlayer;
  }

  public String getCurrentShift() {
    return currentShift;
  }
}
