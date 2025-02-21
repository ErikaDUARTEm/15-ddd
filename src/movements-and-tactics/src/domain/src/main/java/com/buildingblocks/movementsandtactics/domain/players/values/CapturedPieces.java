package com.buildingblocks.movementsandtactics.domain.players.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class CapturedPieces implements IValueObject {
  private List<PlayerPiece> pieces;

  private CapturedPieces(List<PlayerPiece>  piece) {
    this.pieces = new ArrayList<>(piece);
    validate();
  }
  public static CapturedPieces of(List<PlayerPiece>  pieces){
    return new CapturedPieces(pieces);
  }
  @Override
  public void validate() {
    validateNotNull(pieces, "Pieces cannot be null");
  }
  public CapturedPieces addPiece(PlayerPiece piece) {
    List<PlayerPiece> newPieces = new ArrayList<>(this.pieces);
    newPieces.add(piece);
    return CapturedPieces.of(newPieces);
  }

  public List<PlayerPiece> getPieces() {
    return pieces;
  }
}

