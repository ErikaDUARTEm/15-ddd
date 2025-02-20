package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.movements.entities.BoardStatus;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.CapturedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.EndedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.players.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;


public class Movement extends AggregateRoot<MovementId> {
  private Integer idTactic;
  private PlayerId playerId;
  private PositionPiece positionPiece;
  private Shift shift;
  private PieceMovement pieceMovement;
  private BoardStatus boardStatus;

  //region Constructors
  public Movement() {
    super(new MovementId());
    subscribe(new MovementHandler(this));
  }

  private Movement(MovementId identity) {
    super(identity);
  }
  //endregion
  //region Getters and Setters
  public PlayerId getPlayerId() {
    return playerId;
  }

  public void setPlayerId(PlayerId playerId) {
    this.playerId = playerId;
  }

  public PositionPiece getPositionPiece() {
    return positionPiece;
  }

  public void setPositionPiece(PositionPiece positionPiece) {
    this.positionPiece = positionPiece;
  }

  public Integer getIdTactic() {
    return idTactic;
  }

  public void setIdTactic(Integer idTactic) {
    this.idTactic = idTactic;
  }

  public Shift getShift() {
    return shift;
  }

  public void setShift(Shift shift) {
    this.shift = shift;
  }

  public BoardStatus getBoardStatus() {
    return boardStatus;
  }

  public void setBoardStatus(BoardStatus boardStatus) {
    this.boardStatus = boardStatus;
  }

  public PieceMovement getPieceMovement() {
    return pieceMovement;
  }

  public void setPieceMovement(PieceMovement pieceMovement) {
    this.pieceMovement = pieceMovement;
  }
  //endregion
  //region Methods
  public void assignShift(String shiftId, String playerId, String currentShift) {
    apply(new AssignedShift(shiftId, playerId, currentShift));
  }
  public void changeShift(String previousPlayerId, String newPlayerId, String shiftNumber, String currentShift) {
    apply(new ChangedShift(previousPlayerId, newPlayerId, shiftNumber, currentShift));
  }
  public void movePiece(String playerId,String pieceId, Integer row, String column, String color, String type) {
      apply(new MovedPiece(playerId, pieceId, row, column,color, type));
  }
  public void advancePiece(Integer row, String column, String pieceId, String idPlayer, String type, String color) {
      apply(new AdvancedBox(
        row,
        column,
        pieceId,
        idPlayer,
        type,
        color
      ));
  }
  public void endShift(String playerId) {
    apply(new EndedShift(playerId));
  }
  public void recordCurrentShift(String playerId) {
    apply(new RecordedShift(playerId));
  }
  public void validatePieceColor(String pieceColor) {
    apply(new ValidatedPieceColor(pieceMovement.getIdentity(), pieceMovement.getPieceColor(), true));
  }

  public void validatePieceType(String pieceType) {
    apply(new ValidatedPieceType(pieceMovement.getIdentity(), pieceMovement.getPieceType(), true));
  }
  public void capturePiece( String opponentPiece) {
      apply(new CapturedPiece(opponentPiece));
  }
  public void updateBox(Integer row, String column, String piece) {
      apply(new UpdatedBox(row, column, piece));
  }
  public void recordMovement(String movementId) {
      apply(new RecordedMovement(movementId));
  }
  //endregion
}
