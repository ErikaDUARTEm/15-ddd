package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ValidatedPieceType extends DomainEvent {
  public ValidatedPieceType() {
    super(EventsEnum.VALIDATED_PIECE_TYPE.name());
  }
}
