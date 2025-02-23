package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.players.values.CapturedPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.IsCaptured;
import com.buildingblocks.movementsandtactics.domain.players.values.OwnPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerPieceId;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PlayerPieces extends Entity<PlayerPieceId> {
  private OwnPieces ownPieces;
  private CapturedPieces capturedPieces;
  private IsCaptured isCaptured;

  //region Constructors
  public PlayerPieces(PlayerPieceId identity, OwnPieces ownPieces, CapturedPieces capturedPieces, IsCaptured isCaptured) {
    super(identity);
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
    this.isCaptured = isCaptured;
  }
  public PlayerPieces(OwnPieces ownPieces, CapturedPieces capturedPieces, IsCaptured isCaptured) {
    super(new PlayerPieceId());
    this.ownPieces = OwnPieces.of(new ArrayList<>());
    this.capturedPieces = capturedPieces;
    this.isCaptured = isCaptured;
  }
//endregion
  //region Getters and Setters
  public OwnPieces getOwnPieces() {
    return ownPieces;
  }

  public void setOwnPieces(OwnPieces ownPieces) {
    this.ownPieces = ownPieces;
  }

  public CapturedPieces getCapturedPieces() {
    return capturedPieces;
  }

  public void setCapturedPieces(CapturedPieces capturedPieces) {
    this.capturedPieces = capturedPieces;
  }

  public IsCaptured getIsCaptured() {
    return isCaptured;
  }

  public void setIsCaptured(IsCaptured isCaptured) {
    this.isCaptured = isCaptured;
  }

  //endregion
  //region Methods
  public void addPieces(List<PlayerPiece> newPieces) {
    if (this.ownPieces.getPieces().isEmpty()) {
      this.ownPieces = OwnPieces.of(newPieces);
    }
  }
  public void captureOpponentPiece(PlayerPiece opponentPiece) {
    validateNotNull(opponentPiece, "Opponent piece cannot be null");
    List<PlayerPiece> newPieces = new ArrayList<>(this.capturedPieces.getPieces());
    newPieces.add(opponentPiece);
    this.capturedPieces = CapturedPieces.of(newPieces);
  }

  public void removePiece(PlayerPiece piece) {
    List<PlayerPiece> newPieces = new ArrayList<>(this.ownPieces.getPieces());
    newPieces.remove(piece);
    this.ownPieces = OwnPieces.of(newPieces);
  }

//endregion
}
