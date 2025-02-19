package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.entities.BoardStatus;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.CapturedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.EndedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

import java.util.function.Consumer;


public class MovementHandler extends DomainActionsContainer {
  public MovementHandler(Movement movement) {
    add(assignedShift(movement));
    add(changedShift(movement));
    add(movedPiece(movement));
    add(advanceBox(movement));
    add(endedShift(movement));
    add(recordedShift(movement));
    add(validatedPieceColor(movement));
    add(validatedPieceType(movement));
    add(capturePiece(movement));
    add(updatedBox(movement));
    add(recordedMovement(movement));
  }
  public Consumer<? extends DomainEvent> assignedShift(Movement movement){
    return (AssignedShift event) -> {
     movement.getShift().assign(PlayerId.of(event.getIdPlayer()), ShiftId.of(event.getIdShift()));
    };
  }
  public Consumer<? extends DomainEvent> changedShift(Movement movement){
    return (ChangedShift event) -> {
      movement.getShift().change(PlayerId.of(event.getIdNewPlayer()), ShiftId.of(event.getShiftId()));
    };
  }
  public Consumer<? extends DomainEvent> movedPiece(Movement movement){
    return (MovedPiece event) -> {
      movement.getPieceMovement().move(Box.of(event.getRow(), event.getColumn(), event.getPieceId()));
    };
  }
  public Consumer<? extends DomainEvent> advanceBox(Movement movement){
    return (AdvancedBox event) -> {
    PositionPiece positionPiece = PositionPiece.of(
      Box.of(event.getRow(), event.getColumn(), event.getPieceId()),
      Box.of(event.getRow(), event.getColumn(), event.getPieceId()));
      movement.getBoardStatus().advanceBox(positionPiece);
  };
  }
  public Consumer<? extends DomainEvent> endedShift(Movement movement){
    return (EndedShift event) -> {
      movement.getShift().endShift();
    };
  }
  public Consumer<? extends DomainEvent> recordedShift(Movement movement){
    return (RecordedShift event) -> {
      movement.getShift().record();
    };
  }
  public Consumer<? extends DomainEvent> validatedPieceColor(Movement movement){
    return (ValidatedPieceColor event) -> {
      movement.getPieceMovement().validatePieceColor(event.getExpectedColor());
    };
  }
  public Consumer<? extends DomainEvent> validatedPieceType(Movement movement){
    return (ValidatedPieceType event) -> {
      movement.getPieceMovement().validatePieceType(event.getExpectedType());
    };
  }
  public Consumer<? extends DomainEvent> capturePiece(Movement movement){
    return (CapturedPiece event) -> {
      if (movement.getPieceMovement() != null) {
        movement.getPieceMovement().captureOpponentPiece(event.getOpponentPiece());
      }
    };
  }
  public Consumer<? extends DomainEvent> updatedBox(Movement movement) {
    return (UpdatedBox event) -> {
      Box newBox = Box.of(event.getRow(), event.getColumn(), event.getPiece());
      movement.getBoardStatus().updateBox(newBox);
    };
  }
  public Consumer<? extends DomainEvent> recordedMovement(Movement movement) {
    return (RecordedMovement event) -> {
      movement.getBoardStatus().recordMovement(MovementId.of(event.getMovementId()));
    };
  }
}
