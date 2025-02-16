package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ExecutedTactic extends DomainEvent {
  private final Integer idTactic;
  private final Integer idPlayer;
  private final String description;

  public ExecutedTactic(Integer idTactic, Integer idPlayer, String description) {
    super(EventsEnum.EXECUTED_TACTIC.name());
    this.idTactic = idTactic;
    this.idPlayer = idPlayer;
    this.description = description;
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
}