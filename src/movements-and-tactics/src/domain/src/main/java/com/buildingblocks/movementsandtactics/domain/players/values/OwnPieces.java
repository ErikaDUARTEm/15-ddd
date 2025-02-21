package com.buildingblocks.movementsandtactics.domain.players.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class OwnPieces  implements IValueObject {
  private List<PlayerPiece> pieces;

  private OwnPieces(List<PlayerPiece>  piece) {
    this.pieces = new ArrayList<>(piece);
    validate();
  }
  public static OwnPieces of(List<PlayerPiece>  pieces){
    return new OwnPieces(pieces);
  }
  @Override
  public void validate() {
    validateNotNull(pieces, "Pieces cannot be null");
  }

  public List<PlayerPiece> getPieces() {
    return pieces;
  }
}
