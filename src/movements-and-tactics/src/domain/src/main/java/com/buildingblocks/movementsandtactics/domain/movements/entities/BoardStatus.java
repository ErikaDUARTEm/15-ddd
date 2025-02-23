package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.BoardStatusId;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.Boxes;
import com.buildingblocks.movementsandtactics.domain.movements.values.HistoryMovements;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class BoardStatus extends Entity<BoardStatusId> {
  private Boxes boxes;
  private HistoryMovements history;

  //region Constructors
  public BoardStatus( Boxes boxes, HistoryMovements history) {
    super(new BoardStatusId());
    this.boxes = (boxes == null || boxes.getBoxes().isEmpty()) ? initializeBoardIfEmpty() : boxes;
    this.history = HistoryMovements.of(new ArrayList<>());
  }
  public BoardStatus(BoardStatusId identity, Boxes boxes,HistoryMovements history) {
    super(identity);
    this.boxes = boxes;
    this.history = history;
  }
  //endregion
  //region Getters and Setters

  public  HistoryMovements getHistory() {
    return history;
  }

  public void setHistory(HistoryMovements history) {
    this.history = history;
  }

  public Boxes getBoxes() {
    return boxes;
  }
  public void setBoxes(Boxes boxes) {
    this.boxes = boxes;
  }
  //endregion

  //region Methods
  public void advanceBox(PositionPiece positionPiece) {
    Box fromBox = positionPiece.getPositionInitial();
    Box toBox = positionPiece.getPositionFinal();
    if (toBox.isOccupiedBox()) {
      throw new IllegalStateException("Cannot move to an occupied box");
    }
    Box updatedToBox = Box.of(toBox.getRow(), toBox.getColumn(), fromBox.getPieceId());
    updateBox(Box.of(fromBox.getRow(), fromBox.getColumn(), null));
    updateBox(updatedToBox);

  }

  public void updateBox(Box newBox) {
    validateNotNull(newBox, "The new box cannot be null");
    List<Box> updatedBoxes = new ArrayList<>(this.boxes.getBoxes());

    boolean updated = false;
    for (int i = 0; i < updatedBoxes.size(); i++) {
      Box currentBox = updatedBoxes.get(i);
      if (currentBox.getRow().equals(newBox.getRow()) && currentBox.getColumn().equals(newBox.getColumn())) {
        updatedBoxes.set(i, Box.of(newBox.getRow(), newBox.getColumn(), newBox.getPieceId()));
        updated = true;
        break;
      }
    }
    if (!updated) {
      throw new IllegalStateException("Box to update not found");
    }
    System.out.println("Updated boxes:" + updatedBoxes);
  this.boxes = Boxes.of(updatedBoxes);
  }
  public void recordMovement(MovementId movementId) {
      List<MovementId> newMovements = new ArrayList<>(this.history.getMovements());
      newMovements.add(movementId);
      history = HistoryMovements.of(newMovements);
  }
  public Boxes initializeBoardIfEmpty() {
    if (this.boxes == null || this.boxes.getBoxes() == null || this.boxes.getBoxes().isEmpty()) {
      List<Box> initialBoxes = new ArrayList<>();
      for (int row = 1; row <= 8; row++) {
        for (char col = 'A'; col <= 'H'; col++) {
          initialBoxes.add(Box.of(row, String.valueOf(col), null));
        }
      }
      this.boxes = Boxes.of(initialBoxes);
    }
    return this.boxes;
  }
  //endregion
}
