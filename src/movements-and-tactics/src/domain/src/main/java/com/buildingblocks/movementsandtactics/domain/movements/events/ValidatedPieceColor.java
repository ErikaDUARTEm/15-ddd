package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;

public class ValidatedPieceColor extends DomainEvent {
  private final String pieceId;
  private final String expectedColor;
  private final Boolean isValid;

  public ValidatedPieceColor(String pieceId, String expectedColor, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_COLOR.name());

    this.pieceId = pieceId;
    this.expectedColor = expectedColor;
    this.isValid = isValid;
  }

  public String getPieceId() {
    return pieceId;
  }

  public Boolean getValid() {
    return isValid;
  }

  public String getExpectedColor() {
    return expectedColor;
  }
}
