package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class EndedShift extends DomainEvent {
  private final Integer idPlayer;

  public EndedShift(Integer idPlayer) {
    super(EventsEnum.ENDED_SHIFT.name());
    this.idPlayer = idPlayer;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }
}
