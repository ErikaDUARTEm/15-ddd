package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;

public class ValidatedPieceColor extends DomainEvent {
  private final PieceMovementId idPiece;
  private final PieceColor expectedColor;
  private final Boolean isValid;

  public ValidatedPieceColor(PieceMovementId idPiece, PieceColor expectedColor, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_COLOR.name());
    this.idPiece = idPiece;
    this.expectedColor = expectedColor;
    this.isValid = isValid;
  }

  public PieceMovementId getIdPiece() {
    return idPiece;
  }

  public PieceColor getExpectedColor() {
    return expectedColor;
  }

  public Boolean getValid() {
    return isValid;
  }
}
