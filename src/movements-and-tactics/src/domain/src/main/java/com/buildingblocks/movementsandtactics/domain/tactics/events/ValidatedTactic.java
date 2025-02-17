package com.buildingblocks.movementsandtactics.domain.tactics.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ValidatedTactic extends DomainEvent {
  private final Integer idTactic;
  private final Integer idPlayer;
  private final String description;
  private final Boolean isValid;

  public ValidatedTactic(Integer idTactic, Integer idPlayer, String description, Boolean isValid) {
    super(EventsEnum.VALIDATED_TACTIC.name());
    this.idTactic = idTactic;
    this.idPlayer = idPlayer;
    this.description = description;
    this.isValid = isValid;
  }

  public Integer getIdTactic() {
    return idTactic;
  }

  public Integer getIdPlayer() {
    return idPlayer;
  }

  public Boolean getValid() {
    return isValid;
  }

  public String getDescription() {
    return description;
  }
}
