package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.players.events.AddedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

  public PlayerHandler(Player player) {
    add(wonGame(player));
    add(loseGame(player));
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
        piecesFromEvent.add(PlayerPiece.of(event.getColor(), type));
      }
      if (event.getType().equals("PAWN")) {
        for (int i = 0; i < 8; i++) {
          piecesFromEvent.add(PlayerPiece.of(event.getColor(), event.getType()));
        }
      }
      player.getPlayerPieces().addPieces(piecesFromEvent);

    };
  }
}
