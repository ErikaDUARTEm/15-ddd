package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ChangedShift extends DomainEvent {
  private final Integer idPreviousPlayer;
  private final Integer idNewPlayer;

  public ChangedShift(Integer idPreviousPlayer, Integer idNewPlayer) {
    super(EventsEnum.CHANGED_SHIFT.name());
    this.idPreviousPlayer = idPreviousPlayer;
    this.idNewPlayer = idNewPlayer;
  }

  public Integer getIdPreviousPlayer() {
    return idPreviousPlayer;
  }

  public Integer getIdNewPlayer() {
    return idNewPlayer;
  }
}
