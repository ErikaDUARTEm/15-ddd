package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.movementsandtactics.domain.shared.domain.generic.DomainEvent;

public class ValidatedPieceColor extends DomainEvent {
  private final Integer idPiece;
  private final String expectedColor;
  private final Boolean isValid;

  public ValidatedPieceColor(Integer idPiece, String expectedColor, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_COLOR.name());
    this.idPiece = idPiece;
    this.expectedColor = expectedColor;
    this.isValid = isValid;
  }

  public Integer getIdPiece() {
    return idPiece;
  }

  public String getExpectedColor() {
    return expectedColor;
  }

  public Boolean getValid() {
    return isValid;
  }
}
