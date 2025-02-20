package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ValidatedPieceType extends DomainEvent {
  private final Integer idPiece;
  private final String expectedType;
  private final Boolean isValid;

  public ValidatedPieceType(Integer idPiece, String expectedType, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_TYPE.name());
    this.idPiece = idPiece;
    this.expectedType = expectedType;
    this.isValid = isValid;
  }

  public Integer getIdPiece() {
    return idPiece;
  }

  public String getExpectedType() {
    return expectedType;
  }

  public Boolean getValid() {
    return isValid;
  }
}
