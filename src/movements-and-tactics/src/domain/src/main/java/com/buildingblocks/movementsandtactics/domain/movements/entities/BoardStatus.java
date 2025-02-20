package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.BoardStatusId;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.HistoryMovements;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class BoardStatus extends Entity<BoardStatusId> {
  private List<Box> boxes;
  private HistoryMovements history;

  //region Constructors
  public BoardStatus( List<Box> boxes, HistoryMovements history) {
    super(new BoardStatusId());
    this.boxes = boxes;
    this.history = HistoryMovements.of(new ArrayList<>());
  }
  public BoardStatus(BoardStatusId identity, List<Box> boxes,HistoryMovements history) {
    super(identity);
    this.boxes = boxes;
    this.history = HistoryMovements.of(new ArrayList<>());
  }
  //endregion
  //region Getters and Setters

  public  HistoryMovements getHistory() {
    return history;
  }

  public void setHistory(HistoryMovements history) {
    this.history = history;
  }

  public List<Box> getBoxes() {
    return boxes;
  }
  public void setBoxes(List<Box> boxes) {
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
    updateBox(Box.of(fromBox.getRow(), fromBox.getColumn(), null));
    updateBox(toBox);
  }

  public void updateBox(Box newBox) {
    validateNotNull(newBox, "The new box cannot be null");
    for (int i = 0; i < boxes.size(); i++) {
      Box currentBox = boxes.get(i);
      if (currentBox.getRow().equals(newBox.getRow()) && currentBox.getColumn().equals(newBox.getColumn())) {
        boxes.set(i, newBox);
        return;
      }
    }
    throw new IllegalStateException("Box to update not found");
  }
  public void recordMovement(MovementId movementId) {
    this.history = history.add(movementId);
  }
  //endregion
}
