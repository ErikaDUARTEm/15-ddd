package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerPieces;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerStatistics;
import com.buildingblocks.movementsandtactics.domain.players.events.AddedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.CapturedPiece;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerJoinedGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import com.buildingblocks.movementsandtactics.domain.players.events.RemovedPiece;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerName;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;


public class Player extends AggregateRoot<PlayerId> {
  private PlayerName name;
  private PieceColor colorPiece;
  private PlayerStatistics statistics;
  private PlayerPieces playerPieces;
  private Boolean gameEnded;


  //region Constructor
  public Player() {
    super(new PlayerId());
    subscribe(new PlayerHandler(this));
  }
  private Player(PlayerId identity) {
    super(identity);
  }
  //endregion

//region Getters and Setters

  public PlayerName getName() {
    return name;
  }

  public void setName(PlayerName name) {
    this.name = name;
  }

  public PieceColor getColorPiece() {
    return colorPiece;
  }

  public void setColorPiece(PieceColor colorPiece) {
    this.colorPiece = colorPiece;
  }

  public PlayerStatistics getStatistics() {
    return statistics;
  }

  public void setStatistics(PlayerStatistics statistics) {
    this.statistics = statistics;
  }

  public PlayerPieces getPlayerPieces() {
    return playerPieces;
  }

  public void setPlayerPieces(PlayerPieces playerPieces) {
    this.playerPieces = playerPieces;
  }

  public Boolean getGameEnded() {
    return gameEnded;
  }

  public void setGameEnded(Boolean gameEnded) {
    this.gameEnded = gameEnded;
  }
//endregion
//region Domain Actions
  public void winGame(String playerId, String name) {
   apply(new PlayerWonGame(playerId, name));
 }

  public void loseGame(String playerId, String name) {
    apply(new PlayerLostGame(playerId, name));
  }
  public void addedPiece(String pieceId, String color, String type) {
    apply(new AddedPiece(pieceId, color, type));
  }
  public void joinGame(String playerId, String gameId) {
    apply(new PlayerJoinedGame(playerId, gameId));
  }
  public void capturePiece(String pieceId) {
    apply(new CapturedPiece(pieceId));
  }
  public void removePiece(String pieceId, String color, String type) {
    apply(new RemovedPiece(pieceId, color, type));
  }
//endregion
  //region Helpers
  public void messagePlayerJoinedGame(String playerId, String gameId) {
    if (gameId != null) {
      System.out.println(playerId + " joined the game " + gameId);
    }
  }
  public void message(String message) {
    if (message != null) {
      System.out.println(message);
    }
  }
  // endregion
}