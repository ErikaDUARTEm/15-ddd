package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceType;

public class ValidatedPieceType extends DomainEvent {
  private final PieceMovementId idPiece;
  private final PieceType expectedType;
  private final Boolean isValid;

  public ValidatedPieceType(PieceMovementId idPiece,  PieceType expectedType, Boolean isValid) {
    super(EventsEnum.VALIDATED_PIECE_TYPE.name());
    this.idPiece = idPiece;
    this.expectedType = expectedType;
    this.isValid = isValid;
  }

  public  PieceMovementId getIdPiece() {
    return idPiece;
  }

  public  PieceType getExpectedType() {
    return expectedType;
  }

  public Boolean getValid() {
    return isValid;
  }
}
