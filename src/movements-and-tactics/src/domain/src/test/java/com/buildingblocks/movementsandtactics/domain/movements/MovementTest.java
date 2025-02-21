package com.buildingblocks.movementsandtactics.domain.movements;


import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;


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
  void testChangedShift() {
    String previousPlayerId = "Player1";
    String playerIdNew = "Player2";
    String shiftId = "Shift2";
    String currentShift = "Shift1";

    movement.changeShift(previousPlayerId, playerIdNew, shiftId, currentShift);
    Shift updatedShift = movement.getShift();

    System.out.println("Después de cambiar: " + updatedShift.getCurrentShift().getNumberShift());
    assertEquals("Player2", updatedShift.getPlayerId().getValue());
    assertEquals("shift3", updatedShift.getCurrentShift().getNumberShift());
    assertInstanceOf(ChangedShift.class, movement.getUncommittedEvents().get(0));

  }
  @Test
  void movePieceSuccess() {

      String playerId = "initialPlayerId";
      String pieceId = "piece123";
      Integer row = 1;
      String column = "A";
      String color = "blanco";
      String type = "REY";

      movement.movePiece( playerId, pieceId, row, column, color, type);

      assertNotNull(movement.getPlayerId(), "IdPlayer deberia no ser nulo");
      assertEquals(playerId, movement.getShift().getPlayerId().getValue());
      assertInstanceOf(MovedPiece.class, movement.getUncommittedEvents().get(0));
    }
  @Test
  void testAdvanceBoxSuccess() {

    Integer row = 2;
    String column = String.valueOf('A');
    String pieceId = "4";
    String idPlayer = "player1";
    String color = "blanco";
    String type = "REY";

    movement.advancePiece( row, pieceId, idPlayer, column, type, color);

    PositionPiece expectedPosition = PositionPiece.of(
      Box.of(row, column, pieceId),
      Box.of(row, column, pieceId)
    );

    assertInstanceOf(AdvancedBox.class, movement.getUncommittedEvents().get(3));

  }


}