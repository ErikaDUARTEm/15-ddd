package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerPieces;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerStatistics;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
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
  public Player(Boolean gameEnded) {
    super(new PlayerId());
    this.gameEnded = gameEnded;
    subscribe(new PlayerHandler(this));
  }
  private Player(PlayerId identity, Boolean gameEnded) {
    super(identity);
    this.gameEnded = gameEnded;
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

//region Methods
  public void winGame(String playerId, String name) {
  apply(new PlayerWonGame(playerId, name));
}

  public void loseGame(String playerId, String name) {
    apply(new PlayerLostGame(playerId, name));
  }
//endregion
}