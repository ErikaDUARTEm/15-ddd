package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.movementsandtactics.domain.players.Player;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerPieces;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerStatistics;
import com.buildingblocks.movementsandtactics.domain.players.events.AddedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerJoinedGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import com.buildingblocks.movementsandtactics.domain.players.values.OwnPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerName;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
  player.setStatistics(new PlayerStatistics());
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
  @Test
  void shouldUpdateStatisticsAndSendMessageWhenPlayerJoinsGame() {
    PlayerStatistics statistics = player.getStatistics();
    statistics.setGamesPlayed(5);
    player.setGameEnded(true);

    String playerId = "player123";
    String gameId = "game456";
    player.joinGame(playerId, gameId);

    assertEquals(6, player.getStatistics().getGamesPlayed(), "El número de partidas jugadas debe incrementarse en 1.");
    assertFalse(player.getGameEnded(), "El estado del juego debe establecerse en 'false' después de unirse.");
    assertInstanceOf(PlayerJoinedGame.class, player.getUncommittedEvents().get(0));

  }
  @Test
  void shouldIncreaseWinCountAndEndGameWhenPlayerHasNotEndedGame() {
    PlayerStatistics statistics = player.getStatistics();
    statistics.setGamesPlayed(5);
    player.setGameEnded(false);
    statistics.setWinCount(2);
    statistics.setGamesPlayed(5);

    player.winGame("player123", "playerName");

    assertTrue(player.getGameEnded(), "El juego debe marcarse como terminado.");
    assertEquals(3, player.getStatistics().getWinCount(), "El contador de victorias debe incrementarse en 1.");
    assertEquals(6, player.getStatistics().getGamesPlayed(), "El total de juegos jugados debe incrementarse en 1.");
    assertInstanceOf(PlayerWonGame.class, player.getUncommittedEvents().get(0));

}

  @Test
  void shouldNotChangeStatsIfGameAlreadyEndedWhenWinning() {
    PlayerStatistics statistics = player.getStatistics();
    statistics.setGamesPlayed(5);
    player.setGameEnded(true);
    statistics.setWinCount(2);
    statistics.setGamesPlayed(5);

    player.winGame("player123", "playerName");

    assertTrue(player.getGameEnded(), "El juego debe permanecer terminado.");
    assertEquals(2, player.getStatistics().getWinCount(), "El contador de victorias no debe cambiar.");
    assertEquals(5, player.getStatistics().getGamesPlayed(), "El total de juegos jugados no debe cambiar.");
    assertInstanceOf(PlayerWonGame.class, player.getUncommittedEvents().get(0));
  }

@Test
void shouldIncreaseLossCountAndEndGameWhenPlayerHasNotEndedGame() {

  PlayerStatistics statistics = player.getStatistics();
  player.setGameEnded(false);
  statistics.setLossCount(1);
  statistics.setGamesPlayed(5);

   player.loseGame("player123", "playerName");

  assertTrue(player.getGameEnded(), "El juego debe marcarse como terminado.");
  assertEquals(2, player.getStatistics().getLossCount(), "El contador de derrotas debe incrementarse en 1.");
  assertEquals(6, player.getStatistics().getGamesPlayed(), "El total de juegos jugados debe incrementarse en 1.");
  assertInstanceOf(PlayerLostGame.class, player.getUncommittedEvents().get(0));

}

@Test
void shouldNotChangeStatsIfGameAlreadyEndedWhenLosing() {

  PlayerStatistics statistics = player.getStatistics();
  player.setGameEnded(true);
  statistics.setLossCount(1);
  statistics.setGamesPlayed(5);
  player.loseGame("player123", "playerName");

  assertTrue(player.getGameEnded(), "El juego debe permanecer terminado.");
  assertEquals(1, player.getStatistics().getLossCount(), "El contador de derrotas no debe cambiar.");
  assertEquals(5, player.getStatistics().getGamesPlayed(), "El total de juegos jugados no debe cambiar.");
  assertInstanceOf(PlayerLostGame.class, player.getUncommittedEvents().get(0));

}

}
