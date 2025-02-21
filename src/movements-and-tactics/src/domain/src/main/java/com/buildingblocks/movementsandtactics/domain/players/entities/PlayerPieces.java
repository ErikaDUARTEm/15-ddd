package com.buildingblocks.movementsandtactics.domain.players.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.players.values.CapturedPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.OwnPieces;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerPiece;
import com.buildingblocks.movementsandtactics.domain.shared.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerPieceId;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PlayerPieces extends Entity<PlayerPieceId> {
  private OwnPieces ownPieces;
  private CapturedPieces capturedPieces;
  private Boolean isCaptured;

  //region Constructors
  public PlayerPieces(PlayerPieceId identity, OwnPieces ownPieces, CapturedPieces capturedPieces, Boolean isCaptured) {
    super(identity);
    this.ownPieces = ownPieces;
    this.capturedPieces = capturedPieces;
    this.isCaptured = isCaptured;
  }
  public PlayerPieces(OwnPieces ownPieces, CapturedPieces capturedPieces, Boolean isCaptured) {
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
  //endregion
  //region Methods
  public static OwnPieces defaultPieces() {

  }
  public void captureOpponentPiece(PlayerPiece opponentPiece) {
    validateNotNull(opponentPiece, "Opponent piece cannot be null");
    this.capturedPieces.addPiece(opponentPiece);
  }
  public OwnPieces removePiece(PlayerPiece piece) {
    List<PlayerPiece> newPieces = new ArrayList<>();
    newPieces.remove(piece);
    return OwnPieces.of(newPieces);
  }



//endregion
}
