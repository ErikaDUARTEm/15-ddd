package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class FailedTactic extends DomainEvent {
  private final Integer idTactic;
  private final Integer idPlayer;
  private final String description;
  private final String reason;

  public FailedTactic(Integer idTactic, Integer idPlayer, String description, String reason) {
    super(EventsEnum.FAILED_TACTIC.name());
    this.idTactic = idTactic;
    this.idPlayer = idPlayer;
    this.description = description;
    this.reason = reason;
  }

  public Integer getIdTactic() {
    return idTactic;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public String getDescription() {
    return description;
  }

  public String getReason() {
    return reason;
  }
}
