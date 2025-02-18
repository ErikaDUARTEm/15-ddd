package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
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
  }
  public Consumer<? extends DomainEvent> assignedShift(Movement movement){
    return (AssignedShift event) -> {
      movement.assignShiftToPlayer(event.getIdPlayer(), CurrentShift.of(event.getCurrentShift()));
    };
  }
  public Consumer<? extends DomainEvent> changedShift(Movement movement){
    return (ChangedShift event) -> {
      movement.changeShift(event.getIdPreviousPlayer(), event.getIdNewPlayer(), movement.getShift().getCurrentShift().getNumberShift());
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
}
