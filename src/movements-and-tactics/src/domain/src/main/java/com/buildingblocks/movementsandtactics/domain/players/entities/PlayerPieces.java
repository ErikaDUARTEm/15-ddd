package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerPieceId;

import java.util.Set;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PlayerPieces extends Entity<PlayerPieceId> {
  private Set<PlayerPiece> ownPieces;
  private Set<PlayerPiece> capturedPieces;

  //region Constructors
  public PlayerPieces(PlayerPieceId identity, Set<PlayerPiece> ownPieces, Set<PlayerPiece> capturedPieces) {
    super(identity);
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
  }
  public PlayerPieces(Set<PlayerPiece> ownPieces, Set<PlayerPiece> capturedPieces) {
    super(new PlayerPieceId());
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
  }
//endregion
  //region Getters and Setters
  public Set<PlayerPiece> getOwnPieces() {
    return ownPieces;
  }

  public void setOwnPieces(Set<PlayerPiece> ownPieces) {
    this.ownPieces = ownPieces;
  }

  public Set<PlayerPiece> getCapturedPieces() {
    return capturedPieces;
  }

  public void setCapturedPieces(Set<PlayerPiece> capturedPieces) {
    this.capturedPieces = capturedPieces;
  }
  //endregion
  //region Methods
  public void captureOpponentPiece(PlayerPiece opponentPiece) {
    validateNotNull(opponentPiece, "Opponent piece cannot be null");
    this.capturedPieces.add(opponentPiece);
  }
  public void removePiece(PlayerPiece piece) {
    ownPieces.remove(piece);

  }

  public void addPiece(PlayerPiece piece) {
    ownPieces.add(piece);
    // Disparar evento de pieza ganada
  }

//endregion
}
