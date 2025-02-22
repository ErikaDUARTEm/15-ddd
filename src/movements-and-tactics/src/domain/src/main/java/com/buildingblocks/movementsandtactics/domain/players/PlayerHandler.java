package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.players.events.AddedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.CapturedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerJoinedGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import com.buildingblocks.movementsandtactics.domain.players.events.RemovedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.CalculatedWinRate;
import com.buildingblocks.movementsandtactics.domain.players.values.IsCaptured;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

  public PlayerHandler(Player player) {
    add(wonGame(player));
    add(loseGame(player));
    add(addedPiece(player));
    add(playerJoinedGame(player));
    add(pieceCaptured(player));
    add(removedPiece(player));
    add(winRateUpdated(player));
  }
  public Consumer<? extends DomainEvent> wonGame(Player player) {
    return (PlayerWonGame event) -> {
      if (!player.getGameEnded()) {
        player.setGameEnded(true);
        player.getStatistics().setWinCount(player.getStatistics().getWinCount() + 1);
        player.getStatistics().setGamesPlayed(player.getStatistics().getGamesPlayed() + 1);
      }
    };
  }
  public Consumer<? extends DomainEvent> loseGame(Player player){
    return (PlayerLostGame event) -> {
      if(!player.getGameEnded()){
        player.setGameEnded(true);
        player.getStatistics().setLossCount(player.getStatistics().getLossCount() + 1);
        player.getStatistics().setGamesPlayed(player.getStatistics().getGamesPlayed() + 1);
      }
    };
  }
  public Consumer<? extends DomainEvent> addedPiece(Player player){
    return (AddedPiece event) -> {
      List<PlayerPiece> piecesFromEvent = new ArrayList<>();
      List<String> majorPieces = List.of(
        "ROOK",
        "KNIGHT",
        "BISHOP",
        "QUEEN",
        "KING",
        "BISHOP",
        "KNIGHT",
        "ROOK"
      );

      for (String type : majorPieces) {
        piecesFromEvent.add(PlayerPiece.of(event.getPieceId(), event.getColor(), type));
      }
      if (event.getType().equals("PAWN")) {
        for (int i = 0; i < 8; i++) {
          piecesFromEvent.add(PlayerPiece.of(event.getPieceId(), event.getColor(), event.getType()));
        }
      }
      player.getPlayerPieces().addPieces(piecesFromEvent);

    };
  }
  public Consumer<? extends DomainEvent> playerJoinedGame(Player player){
    return (PlayerJoinedGame event) -> {
      player.getStatistics().setGamesPlayed(player.getStatistics().getGamesPlayed() + 1);
      player.setGameEnded(false);
      player.messagePlayerJoinedGame(event.getPlayerId(), event.getGameId());
    };
  }
  public Consumer<? extends DomainEvent> pieceCaptured(Player player) {
    return (CapturedPiece event) -> {
      List<PlayerPiece> opponentPieces = player.getPlayerPieces().getCapturedPieces().getPieces();
      PlayerPiece capturedPiece = opponentPieces.stream()
        .filter(piece -> piece.getPieceId().equals(event.getPieceId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No se encontró la pieza capturada."));

      player.getPlayerPieces().captureOpponentPiece(capturedPiece);
      player.getPlayerPieces().setIsCaptured(IsCaptured.of(true));
      player.message("Captured piece " + event.getPieceId());
    };
  }
  public Consumer<? extends DomainEvent> removedPiece(Player player){
    return (RemovedPiece event) -> {
      player.getPlayerPieces().removePiece(PlayerPiece.of(event.getPieceId(), event.getColor(), event.getType()));
      player.message("Removed piece " + event.getPieceId() + " of type " + event.getType() + " and color " + event.getColor());
    };
  }
  public Consumer<? extends DomainEvent> winRateUpdated(Player player) {
    return (CalculatedWinRate event) -> {
      player.getStatistics().setWinRate(player.getStatistics().calculateWinRate());
      player.message("Win rate updated to " + player.getStatistics().getWinRate());

    };
  }
}
