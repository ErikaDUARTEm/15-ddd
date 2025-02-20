package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
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
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.List;
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
    add(capturedPiece(movement));
    add(updatedBox(movement));
    add(recordedMovement(movement));
  }
  public Consumer<? extends DomainEvent> assignedShift(Movement movement){
   return (AssignedShift event) -> {

     if (movement.getShift() == null) {
       movement.setShift(new Shift(
         PlayerId.of(event.getIdPlayer()),
         CurrentShift.of(event.getCurrentShift(), event.getIdPlayer())
       ));
     } else {
       movement.getShift().setCurrentShift(CurrentShift.of(event.getCurrentShift(), event.getIdPlayer()));
     }
     movement.setPlayerId(PlayerId.of(event.getIdPlayer()));
     movement.getShift().assign(PlayerId.of(event.getIdPlayer()), event.getCurrentShift());
   };

  }
  public Consumer<? extends DomainEvent> changedShift(Movement movement){
    return (ChangedShift event) -> {
      movement.getShift().record();
      CurrentShift newShift = CurrentShift.of(event.getShiftId(), event.getIdNewPlayer());
      if (movement.getShift() != null) {

        movement.getShift().change(PlayerId.of(event.getIdNewPlayer()), event.getShiftId());
        System.out.println("dentro de if1" + movement.getShift().getCurrentShift().getNumberShift());

        movement.getShift().record();

        System.out.println("dentro de if" + movement.getShift().getHistory().getShifts().toString());
        System.out.println("dentro de if" + movement.getShift().getHistory().getShifts().get(2).toString());

      } else {
        movement.setShift(new Shift(
          PlayerId.of(event.getIdNewPlayer()),
          CurrentShift.of(event.getShiftId(), event.getIdNewPlayer())
        ));
        movement.getShift().record();
        movement.getShift().change(PlayerId.of(event.getIdNewPlayer()), event.getShiftId());
        System.out.println("dentro de else" + movement.getShift().getCurrentShift().getNumberShift());
      }

      movement.getShift().setCurrentShift(newShift);
      System.out.println(movement.getShift().getCurrentShift().getNumberShift());
      movement.getShift().getHistory().addShift(newShift);
      List<CurrentShift> shifts = movement.getShift().getHistory().getShifts();
      System.out.println("Tamaño de la lista de shifts: " + shifts.size());
      for (CurrentShift shift : shifts) {
        System.out.println("Shift: " + shift.getNumberShift());
      }

      System.out.println("Historial2 después de cambiar turno: " + movement.getShift().getCurrentShift().getNumberShift());


    };
  }
  public Consumer<? extends DomainEvent> movedPiece(Movement movement){
    return (MovedPiece event) -> {
      movement.setPlayerId(PlayerId.of(event.getIdPlayer()));
      movement.setPieceMovement(new PieceMovement(
        PieceType.of(TypePiece.valueOf(event.getType())),
        PieceColor.of(event.getColor()),
        Box.of(event.getRow(), event.getColumn(), event.getPieceId())
        ));
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
      movement.getShift().endShift(String.valueOf(PlayerId.of(event.getPlayerId())));
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
  public Consumer<? extends DomainEvent> capturedPiece(Movement movement){
    return (CapturedPiece event) -> {
      if (movement.getPieceMovement() != null) {
        movement.getPieceMovement().captureOpponentPiece(PieceMovementId.of(event.getOpponentPiece()));
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
