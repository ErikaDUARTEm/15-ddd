package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.movementsandtactics.domain.players.Player;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerPieces;
import com.buildingblocks.movementsandtactics.domain.players.events.AddedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import com.buildingblocks.movementsandtactics.domain.players.values.OwnPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerName;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
  private Player player;

@BeforeEach
void setUp() {
  player = new Player();
  List<PlayerPiece> pieces = List.of(PlayerPiece.of("pieceId", "WHITE", "ROOK"));
  OwnPieces ownPieces = OwnPieces.of(pieces);
  player.setPlayerPieces(new PlayerPieces(ownPieces, null, null));

}
@Test
  public void wonGame( ){
    player.setGameEnded(true);
    player.setName(PlayerName.of("playerName"));
    player.winGame("playerId", "name");
    assertTrue(player.getGameEnded());
    assertEquals("playerName", player.getName().getName());
    assertInstanceOf(PlayerWonGame.class, player.getUncommittedEvents().get(0));
  }
  @Test
  public void lostGame( ){
    player.setGameEnded(true);
    player.setName(PlayerName.of("playerName"));
    player.loseGame("playerId", "name");
    assertTrue(player.getGameEnded());
    assertEquals("playerName", player.getName().getName());
    assertInstanceOf(PlayerLostGame.class, player.getUncommittedEvents().get(0));
  }

  @Test
  void shouldAddMajorPiecesToPlayer() {
    PlayerPieces playerPieces = player.getPlayerPieces();
    player.addedPiece("1", "WHITE", "ROOK");

    assertEquals(8, playerPieces.getOwnPieces().getPieces().size());
    assertTrue(playerPieces.getOwnPieces().getPieces()
        .stream()
        .allMatch(p -> List.of("ROOK", "KNIGHT", "BISHOP", "QUEEN", "KING").contains(p.getType())));
    assertInstanceOf(AddedPiece.class, player.getUncommittedEvents().get(0));
  }
  @Test
  void shouldAddPawnPiecesToPlayer() {
    PlayerPieces playerPieces = player.getPlayerPieces();
    playerPieces.getOwnPieces().getPieces().clear();
    player.addedPiece("1", "BLACK", "PAWN");
    player.addedPiece("2", "BLACK", "PAWN");

    long pawnCount = player.getPlayerPieces().getOwnPieces().getPieces()
      .stream()
      .filter(piece -> piece.getType().equals("PAWN"))
      .count();

    long majorPiecesCount = player.getPlayerPieces().getOwnPieces().getPieces()
      .stream()
      .filter(piece -> !piece.getType().equals("PAWN"))
      .count();

    assertEquals(8, pawnCount);
    assertEquals(8, majorPiecesCount);
    assertEquals(16, player.getPlayerPieces().getOwnPieces().getPieces().size());
    assertInstanceOf(AddedPiece.class, player.getUncommittedEvents().get(0));
  }



}
