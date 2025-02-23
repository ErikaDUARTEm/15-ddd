package com.buildingblocks.movementsandtactics.domain.movements;


import com.buildingblocks.domain.shared.domain.utils.Color;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;
import com.buildingblocks.movementsandtactics.domain.movements.entities.BoardStatus;
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
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.Boxes;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.HistoryMovements;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsGameEnded;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsValid;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MovementTest {
  private Movement movement;

  @BeforeEach
  void setUp() {
    movement = new Movement();

    List<CurrentShift> initialShifts = List.of(CurrentShift.of("initialCurrentShift", "1"));
    ShiftHistory initialHistory = ShiftHistory.of(initialShifts);
    movement.setShift(new Shift(
      ShiftId.of("initialShiftId"),
      PlayerId.of("initialPlayerId"),
      CurrentShift.of("initialCurrentShift","1"),
      initialHistory
    ));
    List<Box> initialBoxes = new ArrayList<>();
    initialBoxes.add(Box.of(2, "B", null));
    Boxes initialBoxesBoxes = Boxes.of(initialBoxes);

    BoardStatus initialBoardStatus = new BoardStatus(initialBoxesBoxes, HistoryMovements.of(new ArrayList<>()));
    movement.setBoardStatus(initialBoardStatus);
    movement.setPieceMovement(new PieceMovement(PieceType.of(TypePiece.ROOK), PieceColor.of(Color.valueOf("WHITE")), Box.of(1, "A", null)));

  }

  @Test
  void testAssignShiftToPlayerSuccess() {
    String shiftId = "initialShiftId";
    String playerId = "initialPlayerId";
    String currentShift = "initialCurrentShift";

    movement.assignShift(shiftId, playerId, currentShift);

    assertNotNull(movement.getShift(), "Shift deberia no ser nulo");
    assertNotNull(movement.getPlayerId(), "IdPlayer deberia no ser nulo");
    assertNotNull(movement.getShift().getCurrentShift(), "CurrentShift deberia no ser nulo");

    assertEquals(shiftId, movement.getShift().getIdentity().getValue());
    assertEquals(playerId, movement.getShift().getPlayerId().getValue());
    assertEquals(currentShift, movement.getShift().getCurrentShift().getNumberShift());
    assertInstanceOf(AssignedShift.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void testChangeShift() {
    String newPlayerId = "newPlayerId";
    String newShiftNumber = "newShiftNumber";

    movement.changeShift(newPlayerId, newShiftNumber);

    List<CurrentShift> shifts = List.copyOf(movement.getShift().getHistory().getShifts());
    assertEquals(4, shifts.size());
    CurrentShift currentShift = shifts.get(1);
    assertEquals(newShiftNumber, currentShift.getNumberShift());
    assertEquals(newPlayerId, currentShift.getPlayerId());
    assertInstanceOf(ChangedShift.class, movement.getUncommittedEvents().get(0));
  }

  @Test
  void movePieceSuccess() {

      String playerId = "initialPlayerId";
      String pieceId = "piece123";
      Integer row = 1;
      String column = "A";
      String color = "WHITE";
      String type = "ROOK";

      movement.movePiece( playerId, pieceId, row, column, color, type);

      assertNotNull(movement.getPlayerId(), "IdPlayer deberia no ser nulo");
      assertEquals(playerId, movement.getShift().getPlayerId().getValue());
      assertInstanceOf(MovedPiece.class, movement.getUncommittedEvents().get(0));
    }
  @Test
  void testAdvanceBoxSuccess() {
    BoardStatus boxes = movement.getBoardStatus();
    List<Box> initialBox = List.of(Box.of(1, "A", null));
    Boxes initialBoxes = Boxes.of(initialBox);
    boxes.setBoxes(initialBoxes);
    Integer row = 1;
    String column = String.valueOf('A');
    String pieceId = "4";
    String color = "WHITE";
    String type = "ROOK";

    movement.advanceBox( row, column,  pieceId, type, color);

    Box updatedBox = movement.getBoardStatus().getBoxes().getBoxes().get(0);

    assertNotNull(updatedBox, "La caja debería existir en el tablero.");
    assertEquals(row, updatedBox.getRow(), "La fila de la caja no coincide.");
    assertEquals(column, updatedBox.getColumn(), "La columna de la caja no coincide.");
    assertEquals(pieceId, updatedBox.getPieceId(), "La pieza en la caja no se actualizó correctamente.");
    assertInstanceOf(AdvancedBox.class, movement.getUncommittedEvents().get(0));

  }
  @Test
  void endShift() {
    movement.endShift("newPlayerId");
    assertInstanceOf(EndedShift.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void recordedShift() {
    Shift shift = movement.getShift();
    List<CurrentShift> initialShifts = List.of(CurrentShift.of("initialCurrentShift", "1"));
    ShiftHistory initialHistory = ShiftHistory.of(initialShifts);
    shift.setHistory(initialHistory);

    String playerId = "newPlayerId";
    String idShift = "idShift";
    movement.recordShift(playerId, idShift);

    assertNotNull(movement.getShift());
    assertEquals(2, movement.getShift().getHistory().getShifts().size());
    CurrentShift lastShift = movement.getShift().getHistory().getShifts().get(1);
    assertEquals(playerId, lastShift.getPlayerId());
    assertEquals(idShift, lastShift.getNumberShift());

    RecordedShift recordedShiftEvent = (RecordedShift) movement.getUncommittedEvents().get(0);
    assertEquals(playerId, recordedShiftEvent.getPlayerId());
    assertEquals(idShift, recordedShiftEvent.getIdShift());
    assertInstanceOf(RecordedShift.class, movement.getUncommittedEvents().get(0));


  }
  @Test
  void validatedPieceColor() {
    String pieceId = "piece123";
    String expectedColor = "WHITE";
    Boolean isValid = true;

    movement.validatePieceColor(pieceId, expectedColor, isValid);

    assertTrue(movement.getIsValid().getValue());
    assertEquals(expectedColor, movement.getPieceMovement().getPieceColor().getColor().name());
    assertInstanceOf(ValidatedPieceColor.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void validatePieceColorInvalid() {
    String pieceId = "piece123";
    String expectedColor = "BLACK";
    Boolean isValid = false;

    movement.validatePieceColor(pieceId, expectedColor, isValid);

    assertNotEquals(expectedColor, movement.getPieceMovement().getPieceColor().getColor().name());
  }
  @Test
  void validatedPieceType() {
    String pieceId = "piece123";
    String expectedType = "ROOK";
    Boolean isValid = true;

    movement.validatePieceType(pieceId, expectedType, isValid);

    assertTrue(movement.getIsValid().getValue());
    assertEquals(expectedType, movement.getPieceMovement().getPieceType().getType().name());
    assertInstanceOf(ValidatedPieceType.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void inValidatedPieceType() {
    String pieceId = "piece123";
    String expectedType = "ROOK";
    Boolean isValid = false;

    movement.validatePieceType(pieceId, expectedType, isValid);

    assertNotEquals(expectedType, movement.getPieceMovement().getPieceType().getType());
    assertInstanceOf(ValidatedPieceType.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void updatedBox() {
    BoardStatus boxes = movement.getBoardStatus();
    List<Box> initialBox = List.of(Box.of(1, "A", null));
    Boxes initialBoxes = Boxes.of(initialBox);

    Integer row = 1;
    String column = String.valueOf('A');
    String pieceId = "4";

    boxes.setBoxes(initialBoxes);
    for (Box box : boxes.getBoxes().getBoxes()) {
      System.out.println("Fila: " + box.getRow() + ", Columna: " + box.getColumn() + ", Pieza: " + box.getPieceId());
    }
    movement.updateBox(row, column, pieceId);
    assertNotNull(boxes);
    assertEquals(row, boxes.getBoxes().getBoxes().get(0).getRow());
    assertEquals(column, boxes.getBoxes().getBoxes().get(0).getColumn());
    assertEquals(pieceId, boxes.getBoxes().getBoxes().get(0).getPieceId());
    assertInstanceOf(UpdatedBox.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void recordMovement() {
    BoardStatus boardStatus = movement.getBoardStatus();
    String movementId = "movementId1";

    movement.recordMovement(movementId);

    assertFalse(boardStatus.getHistory().getMovements().isEmpty());
    assertEquals(1, boardStatus.getHistory().getMovements().size());
    assertEquals(movementId, boardStatus.getHistory().getMovements().get(0).getValue());
  }
  @Test
  void gameEnded() {
    movement.setIsGameEnded(IsGameEnded.of(true));
    movement.endGame("winnerId", "loserId");
    assertTrue(movement.getIsGameEnded().getValue());
    assertInstanceOf(GameEnded.class, movement.getUncommittedEvents().get(0));

  }
  @Test
  void validateCorrectMovement() {
    BoardStatus boxes = movement.getBoardStatus();
    List<Box> initialBox = List.of(Box.of(1, "A", "4"));
    Boxes initialBoxes = Boxes.of(initialBox);
    boxes.setBoxes(initialBoxes);

    Integer row = 2;
    String column = "B";
    String pieceId = "4";

    movement.validateMovement("idMovement", "idPlayer", row, column, pieceId);

    assertTrue(movement.getIsValid().getValue(), "El movimiento deberia ser valido.");
    assertInstanceOf(ValidatedMovement.class, movement.getUncommittedEvents().get(0));
  }

  @Test
  void validateInvalidMovement() {

    movement.setIsValid(IsValid.of(false));

    String reason = "Fuera de los límites del tablero";
    movement.inValidateMovement("idMovement", "idPlayer", 2, "B", "4", reason);

    assertFalse(movement.getIsValid().getValue(), "El movimiento debería permanecer inválido");
    assertInstanceOf(InvalidMovement.class, movement.getUncommittedEvents().get(0));
  }
  @Test
  void executeMovement() {

    BoardStatus boardStatus = movement.getBoardStatus();
    List<Box> initialBox = List.of(Box.of(1, "A", "4"));
    Boxes initialBoxes = Boxes.of(initialBox);
    boardStatus.setBoxes(initialBoxes);

    Integer newRow = 2;
    String newColumn = "B";
    String pieceId = "4";

    movement.setIsValid(IsValid.of(true));
    movement.executeMovement("idMovement", "idPlayer", newRow, newColumn, pieceId);

    Box updatedBox = boardStatus.getBoxes().getBoxes()
      .stream()
      .filter(box -> box.getPieceId() != null && box.getPieceId().equals(pieceId))
      .findFirst()
      .orElse(null);
    boardStatus.setBoxes(initialBoxes);
    assertNotNull(updatedBox, "La pieza debería haberse movido.");
    assertEquals(newRow, updatedBox.getRow(), "La fila no se actualizó correctamente.");
    assertEquals(newColumn, updatedBox.getColumn(), "La columna no se actualizó correctamente.");
    assertInstanceOf(ExecutedMovement.class, movement.getUncommittedEvents().get(0));
  }

  @Test
  void updateMovement() {
    BoardStatus boardStatus = movement.getBoardStatus();
    List<Box> initialBox = List.of(Box.of(1, "A", "4"));
    Boxes initialBoxes = Boxes.of(initialBox);
    boardStatus.setBoxes(initialBoxes);

    Integer row = 2;
    String column = "B";
    String pieceId = "4";

    movement.updatedMovement("idMovement", "idPlayer", row, column, pieceId);

    Box updatedBox = boardStatus.getBoxes().getBoxes()
      .stream()
      .filter(box -> box.getPieceId() != null && box.getPieceId().equals(pieceId))
      .findFirst()
      .orElse(null);
    boardStatus.setBoxes(initialBoxes);
    assertNotNull(updatedBox);
    assertEquals(row, updatedBox.getRow());
    assertEquals(column, updatedBox.getColumn());
    assertInstanceOf(UpdatedMovement.class, movement.getUncommittedEvents().get(0));
  }
  }

