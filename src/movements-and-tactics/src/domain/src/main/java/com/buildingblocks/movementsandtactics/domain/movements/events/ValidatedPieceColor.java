package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ValidatedPieceColor extends DomainEvent {
  public ValidatedPieceColor() {
    super(EventsEnum.VALIDATED_PIECE_COLOR.name());
  }
}
