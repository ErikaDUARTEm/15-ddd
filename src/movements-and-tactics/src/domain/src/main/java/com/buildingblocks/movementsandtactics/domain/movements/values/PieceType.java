package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceType implements IValueObject {
  private final TypePiece typePiece;

  private PieceType(TypePiece typePiece) {
    this.typePiece = typePiece;
    validate();
  }
  public static PieceType of(TypePiece typePiece){
    return new PieceType(typePiece);
  }

  @Override
  public void validate() {
    validateNotNull(typePiece, "type cannot be null");
  }
  public TypePiece getType() {
    return typePiece;
  }
}
