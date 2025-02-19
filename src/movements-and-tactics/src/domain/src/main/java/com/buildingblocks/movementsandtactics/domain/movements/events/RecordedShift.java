package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class RecordedShift extends DomainEvent {
  private final String idPlayer;

  public RecordedShift(String idPlayer) {
    super(EventsEnum.RECORDED_SHIFT.name());
    this.idPlayer = idPlayer;
  }

  public String getIdPlayer() {
    return idPlayer;
  }
}
