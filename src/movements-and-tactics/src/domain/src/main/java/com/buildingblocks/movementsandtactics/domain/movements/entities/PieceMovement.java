package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceType;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceMovement extends Entity<PieceMovementId> {
  private PieceType pieceType;
  private PieceColor pieceColor;
  private Box currentBox;

  //region Constructors
  public PieceMovement(PieceType pieceType, PieceColor pieceColor, Box currentBox) {
    super(new PieceMovementId());
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
    this.currentBox = currentBox;
  }
  public PieceMovement(PieceMovementId identity,PieceType pieceType, PieceColor pieceColor,Box currentBox ) {
    super(identity);
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
    this.currentBox = currentBox;
  }
  //endregion
  //region Getters and Setters
  public PieceType getPieceType() {
    return pieceType;
  }

  public void setPieceType(PieceType pieceType) {
    this.pieceType = pieceType;
  }

  public PieceColor getPieceColor() {
    return pieceColor;
  }

  public void setPieceColor(PieceColor pieceColor) {
    this.pieceColor = pieceColor;
  }

  public Box getCurrentBox() {
    return currentBox;
  }

  public void setCurrentBox(Box currentBox) {
    this.currentBox = currentBox;
  }
  //endregion
  //region Methods
  public void move(Box newBox) {
    validateNotNull(newBox, "The new box cannot be null");
    this.currentBox = newBox;
  }
  public void validatePieceColor(PieceColor pieceColor) {
    pieceColor.validate();
  }

  public void validatePieceType(PieceType pieceType) {
    pieceType.validate();
  }
  public boolean captureOpponentPiece(PieceMovement opponentPiece) {
    validateNotNull(opponentPiece, "Opponent piece cannot be null");
    if (this.currentBox.equals(opponentPiece.getCurrentBox())) {
      opponentPiece.setCurrentBox(null);
      return true;
    }
    return false;
  }
  //endregion
}
