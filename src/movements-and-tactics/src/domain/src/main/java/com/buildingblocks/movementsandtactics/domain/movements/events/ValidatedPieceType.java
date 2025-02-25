package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class ValidatedPieceType extends DomainEvent {
  private final String pieceId;
  private final String expectedType;
  private final Boolean isValid;

  public ValidatedPieceType(String pieceId, String expectedType, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_TYPE.name());
    this.pieceId = pieceId;
    this.expectedType = expectedType;
    this.isValid = isValid;
  }

  public String getPieceId() {
    return pieceId;
  }

  public String getExpectedType() {
    return expectedType;
  }

  public Boolean getValid() {
    return isValid;
  }
}
