package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PiecesInvolved implements IValueObject {

  private List<String> pieces;

  private PiecesInvolved(List<String> pieces) {
    this.pieces = pieces;
    validate();
  }
  public static PiecesInvolved of(List<String> pieces){
    return new PiecesInvolved(pieces);
  }

  @Override
  public void validate() {
    for (String piece : pieces) {
      validateNotEmpty(piece, "pieces cannot be empty");
      validateNotNull(piece, "pieces cannot be null");
    }
  }

  public List<String> getPieces() {
    return pieces;
  }
}
