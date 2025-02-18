package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.CapturedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.EndedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

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


  }
  public Consumer<? extends DomainEvent> assignedShift(Movement movement){
    return (AssignedShift event) -> {
      movement.assignShiftToPlayer(event.getIdPlayer(), CurrentShift.of(event.getIdShift()));
    };
  }
  public Consumer<? extends DomainEvent> changedShift(Movement movement){
    return (ChangedShift event) -> {
      movement.changeShift(event.getIdPreviousPlayer(), event.getIdNewPlayer(), event.getShiftId());
    };
  }
  public Consumer<? extends DomainEvent> movedPiece(Movement movement){
    return (MovedPiece event) -> {
      movement.movePiece(event.getIdPlayer(), event.getIdPiece(), event.getPositionInitial(), event.getPositionFinal());
    };
  }
  public Consumer<? extends DomainEvent> advanceBox(Movement movement){
    return (AdvancedBox event) -> {
    PositionPiece positionPiece = PositionPiece.of(
      Box.of(event.getRow(), event.getColumn(), event.getPiece()),
      Box.of(event.getRow(), event.getColumn(), event.getPiece()));
    movement.advancePiece(positionPiece);
  };
  }
  public Consumer<? extends DomainEvent> endedShift(Movement movement){
    return (EndedShift event) -> {
      movement.endShift(event.getIdPlayer());
    };
  }
  public Consumer<? extends DomainEvent> recordedShift(Movement movement){
    return (RecordedShift event) -> {
      movement.recordCurrentShift(event.getIdPlayer());
    };
  }
  public Consumer<? extends DomainEvent> validatedPieceColor(Movement movement){
    return (ValidatedPieceColor event) -> {
      movement.validatePieceColor(event.getExpectedColor());
    };
  }
  public Consumer<? extends DomainEvent> validatedPieceType(Movement movement){
    return (ValidatedPieceType event) -> {
      movement.validatePieceType(event.getExpectedType());
    };
  }
  public Consumer<? extends DomainEvent> capturePiece(Movement movement){
    return (CapturedPiece event) -> {
      movement.capturePiece(event.getOpponentPiece());
    };
  }
}
