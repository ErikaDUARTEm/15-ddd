package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerPieces;
import com.buildingblocks.movementsandtactics.domain.players.entities.PlayerStatistics;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerName;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;


public class Player extends AggregateRoot<PlayerId> {
  private PlayerName name;
  private PieceColor colorPiece;
  private PlayerStatistics statistics;
  private PlayerPieces playerPieces;


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


//endregion

//region Methods
//endregion
}