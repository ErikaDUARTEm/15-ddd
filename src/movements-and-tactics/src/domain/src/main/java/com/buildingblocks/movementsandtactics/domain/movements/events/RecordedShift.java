package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class RecordedShift extends DomainEvent {
  private final String playerId;
  private final String idShift;

  public RecordedShift(String playerId, String idShift) {
    super(EventsEnum.RECORDED_SHIFT.name());
    this.playerId = playerId;
    this.idShift = idShift;

  }
  public String getIdShift() {
    return idShift;
  }

  public String getPlayerId() {
    return playerId;
  }
}
