package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class RecordedShift extends DomainEvent {
  private final Integer idPlayer;

  public RecordedShift(Integer idPlayer) {
    super(EventsEnum.RECORDED_SHIFT.name());
    this.idPlayer = idPlayer;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }
}
