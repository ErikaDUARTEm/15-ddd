package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.domain.shared.domain.utils.Column;
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
import com.buildingblocks.movementsandtactics.domain.movements.values.Box;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceMovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.List;


public class Movement extends AggregateRoot<MovementId> {
  private Integer idTactic;
  private Integer idPlayer;
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
  public Integer getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(Integer idPlayer) {
    this.idPlayer = idPlayer;
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
  public void assignShiftToPlayer(String shiftId, String playerId, String currentShift) {
    apply(new AssignedShift(shiftId, playerId, currentShift));
  }
  public void changeShift(String previousPlayerId, String newPlayerId, String shiftNumber, String CurrentShift) {
    apply(new ChangedShift(previousPlayerId, newPlayerId, shiftNumber, CurrentShift));
  }
  public void movePiece(String playerId,String pieceId, Integer row, String column) {
      apply(new MovedPiece(playerId, pieceId, row, column));
  }
  public void advancePiece(Integer row, String column, String pieceId, String idPlayer) {
      apply(new AdvancedBox(
        row,
        column,
        pieceId,
        idPlayer
      ));
  }
  public void endShift() {
    apply(new EndedShift());
  }
  public void recordCurrentShift(String idPlayer) {
    apply(new RecordedShift(idPlayer));
  }
  public void validatePieceColor(PieceColor pieceColor) {
    apply(new ValidatedPieceColor(pieceMovement.getIdentity(), pieceMovement.getPieceColor(), true));
  }

  public void validatePieceType(PieceType pieceType) {
    apply(new ValidatedPieceType(pieceMovement.getIdentity(), pieceMovement.getPieceType(), true));
  }
  public void capturePiece(PieceMovement opponentPiece) {
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
