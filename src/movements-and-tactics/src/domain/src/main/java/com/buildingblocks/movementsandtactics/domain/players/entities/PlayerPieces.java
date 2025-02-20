package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.players.values.PiecePlayer;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiecesId;

import java.util.Set;

public class PlayerPieces extends Entity<PlayerPiecesId> {
  private Set<PiecePlayer> ownPieces;
  private Set<PiecePlayer> capturedPieces;

  //region Constructors
  public PlayerPieces(PlayerPiecesId identity, Set<PiecePlayer> ownPieces, Set<PiecePlayer> capturedPieces) {
    super(identity);
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
  }
  public PlayerPieces(Set<PiecePlayer> ownPieces, Set<PiecePlayer> capturedPieces) {
    super(new PlayerPiecesId());
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
  }
//endregion
  //region Getters and Setters
  public Set<PiecePlayer> getOwnPieces() {
    return ownPieces;
  }

  public void setOwnPieces(Set<PiecePlayer> ownPieces) {
    this.ownPieces = ownPieces;
  }

  public Set<PiecePlayer> getCapturedPieces() {
    return capturedPieces;
  }

  public void setCapturedPieces(Set<PiecePlayer> capturedPieces) {
    this.capturedPieces = capturedPieces;
  }
  //endregion
}
