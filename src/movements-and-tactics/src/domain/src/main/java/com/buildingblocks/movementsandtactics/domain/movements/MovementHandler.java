package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.domain.shared.domain.utils.Color;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.EndedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ExecutedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.GameEnded;
import com.buildingblocks.movementsandtactics.domain.movements.events.InvalidMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.Boxes;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsGameEnded;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsValid;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
    add(updatedBox(movement));
    add(recordedMovement(movement));
    add(gameEnded(movement));
    add(validatedMovement(movement));
    add(executedMovement(movement));
    add(invalidMovement(movement));
    add(updatedMovement(movement));

  }

  public Consumer<? extends DomainEvent> assignedShift(Movement movement) {
    return (AssignedShift event) -> {

      if (movement.getShift() == null) {
        movement.setShift(new Shift(
          PlayerId.of(event.getIdPlayer()),
          CurrentShift.of(event.getCurrentShift(), event.getIdPlayer())
        ));
      } else {
        movement.getShift().setCurrentShift(CurrentShift.of(event.getCurrentShift(), event.getIdPlayer()));
      }
      movement.getShift().assign( event.getCurrentShift(), PlayerId.of(event.getIdPlayer()));
      movement.setPlayerId(PlayerId.of(event.getIdPlayer()));
    };

  }

  public Consumer<? extends DomainEvent> changedShift(Movement movement) {
    return (ChangedShift event) -> {

      if (movement.getShift() != null) {

        movement.getShift().change(PlayerId.of(event.getIdNewPlayer()), event.getShiftId());
        movement.getShift().record(event.getIdNewPlayer(), event.getShiftId());

      } else {
        movement.setShift(new Shift(
          PlayerId.of(event.getIdNewPlayer()),
          CurrentShift.of(event.getShiftId(), event.getIdNewPlayer())
        ));
        movement.getShift().change(PlayerId.of(event.getIdNewPlayer()), event.getShiftId());
        movement.getShift().record(event.getIdNewPlayer(), event.getShiftId());
      }
      movement.getShift().setCurrentShift(CurrentShift.of(event.getShiftId(), event.getIdNewPlayer()));
      movement.getShift().addShift(CurrentShift.of(event.getShiftId(), event.getIdNewPlayer()));
      movement.setPlayerId(PlayerId.of(event.getIdNewPlayer()));
    };
  }

  public Consumer<? extends DomainEvent> movedPiece(Movement movement) {
    return (MovedPiece event) -> {
      movement.setPlayerId(PlayerId.of(event.getIdPlayer()));
      movement.setPieceMovement(new PieceMovement(
        PieceType.of(TypePiece.valueOf(event.getType())),
        PieceColor.of(Color.valueOf(event.getColor())),
        Box.of(event.getRow(), event.getColumn(), event.getPieceId())
      ));
      movement.getPieceMovement().move(Box.of(event.getRow(), event.getColumn(), event.getPieceId()));
      movement.getPieceMovement().setCurrentBox(Box.of(event.getRow(), event.getColumn(), event.getPieceId()));
    };

  }

  public Consumer<? extends DomainEvent> advanceBox(Movement movement) {
    return (AdvancedBox event) -> {
      if (movement.getBoardStatus() != null) {
        Box initialBox = Box.of(event.getRow(), event.getColumn(), event.getPieceId());
        Box destinationBox = Box.of(event.getRow(), event.getColumn(), null);

        PositionPiece positionPiece = PositionPiece.of(
          initialBox,
          destinationBox);

        movement.getBoardStatus().advanceBox(positionPiece);
        movement.getBoardStatus().recordMovement(MovementId.of(event.getAggregateRootId()));
        movement.getPieceMovement().setCurrentBox(Box.of(event.getRow(), event.getColumn(), event.getPieceId()));

      };
    };
  }

  public Consumer<? extends DomainEvent> endedShift(Movement movement) {
    return (EndedShift event) -> {
      if (movement.getShift().getPlayerId() != null) {
        movement.getShift().endShift(String.valueOf(PlayerId.of(event.getPlayerId())));
      }
    };
  }

  public Consumer<? extends DomainEvent> recordedShift(Movement movement) {
    return (RecordedShift event) -> {
      movement.getShift().record(event.getPlayerId(), event.getIdShift());
    };
  }

  public Consumer<? extends DomainEvent> validatedPieceColor(Movement movement) {
    return (ValidatedPieceColor event) -> {
      movement.setIsValid(IsValid.of(true));
      movement.getPieceMovement().validatePieceColor(PieceColor.of(Color.valueOf(event.getExpectedColor())));
    };
  }

  public Consumer<? extends DomainEvent> validatedPieceType(Movement movement) {
    return (ValidatedPieceType event) -> {
      movement.setIsValid(IsValid.of(true));
      movement.getPieceMovement().validatePieceType(PieceType.of(TypePiece.valueOf(event.getExpectedType())));
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

  public Consumer<? extends DomainEvent> gameEnded(Movement movement) {
    return (GameEnded event) -> {
      movement.setIsGameEnded(IsGameEnded.of(true));
    };
  }
  public Consumer<? extends DomainEvent> validatedMovement(Movement movement) {
    return (ValidatedMovement event) -> {
      List<Box> boxes = new ArrayList<>(movement.getBoardStatus().getBoxes().getBoxes());

      Box initialBox = boxes.stream()
        .filter(box -> box.getPieceId() != null && box.getPieceId().equals(event.getPieceId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No se encontró la pieza en el tablero."));

      Box destinationBox = Box.of(event.getRow(), event.getColumn(), event.getPieceId());
      PositionPiece positionPiece = PositionPiece.of(initialBox, destinationBox);
      if (initialBox.equals(destinationBox)) {
        movement.setIsValid(IsValid.of(false));
      }
      boolean isOccupied = boxes.stream()
        .filter(box -> box.hasSameCoordinates(destinationBox))
        .anyMatch(Box::isOccupiedBox);

      if (isOccupied) {
        throw new IllegalStateException("La casilla destino ya está ocupada.");
      }
      movement.setIsValid(IsValid.of(true));
    };
  }
  public Consumer<? extends DomainEvent> executedMovement(Movement movement) {
    return (ExecutedMovement event) -> {
      List<Box> boxes = new ArrayList<>(movement.getBoardStatus().getBoxes().getBoxes());

      Box initialBox = boxes.stream()
        .filter(box -> box.getPieceId() != null && box.getPieceId().equals(event.getPieceId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No se encontró la pieza en el tablero."));

      Optional<Box> existingBox = boxes.stream()
        .filter(box -> box.getRow().equals(event.getRow()) && box.getColumn().equals(event.getColumn()))
        .findFirst();

      Box destinationBox = Box.of(event.getRow(), event.getColumn(), event.getPieceId());
      PositionPiece positionPiece = PositionPiece.of(initialBox, destinationBox);

      if (!movement.getIsValid().getValue()) {
        throw new IllegalStateException("Movimiento no válido.");
      }
      movement.getBoardStatus().advanceBox(positionPiece);
      movement.getBoardStatus().recordMovement(MovementId.of(event.getIdMovement()));
    };
  }

  public Consumer<? extends DomainEvent> invalidMovement(Movement movement) {
    return (InvalidMovement event) -> {
      movement.setIsValid(IsValid.of(false));
      String mensaje = "El movimiento no es válido. " + event.getReason();
      movement.messageMovementInvalid(mensaje);
    };
  }

  public Consumer<? extends DomainEvent> updatedMovement(Movement movement) {
    return (UpdatedMovement event) -> {
      List<Box> boxes = new ArrayList<>(movement.getBoardStatus().getBoxes().getBoxes());

      Box initialBox = boxes.stream()
        .filter(box -> box.getPieceId() != null && box.getPieceId().equals(event.getPieceId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No se encontró la pieza en el tablero."));

      Box destinationBox = Box.of(event.getRow(), event.getColumn(), event.getPieceId());
      PositionPiece positionPiece = PositionPiece.of(initialBox, destinationBox);

      movement.getBoardStatus().advanceBox(positionPiece);
      movement.getBoardStatus().recordMovement(MovementId.of(event.getIdMovement()));
    };
  }


}