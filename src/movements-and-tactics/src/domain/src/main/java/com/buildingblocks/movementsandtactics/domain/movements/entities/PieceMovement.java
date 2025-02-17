package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceType;

import javax.swing.*;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PieceMovement extends Entity<PieceMovementId> {
  private PieceType pieceType;
  private PieceColor pieceColor;
  private Box currentBox;

  public PieceMovement(PieceType pieceType, PieceColor pieceColor, Box initialBox) {
    super(new PieceMovementId());
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
    this.currentBox = initialBox;
  }
  PieceMovement(PieceMovementId identity,PieceType pieceType, PieceColor pieceColor) {
    super(identity);
    this.pieceType = pieceType;
    this.pieceColor = pieceColor;
  }
  public void move(Box newBox) {
     validateNotNull(newBox.toString(), "The new box cannot be null");
    this.currentBox = newBox;
  }

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
}
