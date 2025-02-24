package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.movements.entities.BoardStatus;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.EndedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ExecutedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.GameEnded;
import com.buildingblocks.movementsandtactics.domain.movements.events.InvalidMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.RecordedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.UpdatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedMovement;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceColor;
import com.buildingblocks.movementsandtactics.domain.movements.events.ValidatedPieceType;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsGameEnded;
import com.buildingblocks.movementsandtactics.domain.movements.values.IsValid;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;

import java.util.List;


public class Movement extends AggregateRoot<MovementId> {
  private Integer idTactic;
  private PlayerId playerId;
  private PositionPiece positionPiece;
  private Shift shift;
  private PieceMovement pieceMovement;
  private BoardStatus boardStatus;
  private IsGameEnded isGameEnded;
  private IsValid isValid;

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

  public IsGameEnded getIsGameEnded() {
    return isGameEnded;
  }

  public void setIsGameEnded(IsGameEnded isGameEnded) {
    this.isGameEnded = isGameEnded;
  }

  public IsValid getIsValid() {
    return isValid;
  }

  public void setIsValid(IsValid isValid) {
    this.isValid = isValid;
  }

  //endregion
  // region Domain Actions
  public void assignShift(String shiftId, String playerId, String currentShift) {
    apply(new AssignedShift(shiftId, playerId, currentShift));
  }
  public void changeShift(String newPlayerId, String shiftNumber) {
    apply(new ChangedShift(newPlayerId, shiftNumber));
  }
  public void movePiece(String playerId,String pieceId, Integer row, String column, String color, String type) {
      apply(new MovedPiece(playerId, pieceId, row, column,color, type));
  }
  public void advanceBox(Integer row, String column, String pieceId, String type, String color) {
      apply(new AdvancedBox(
        row,
        column,
        pieceId,
        type,
        color
      ));
  }
  public void endShift(String playerId) {
    apply(new EndedShift(playerId));
  }
  public void recordShift(String playerId, String idShift) {
    apply(new RecordedShift(playerId, idShift));
  }
  public void validatePieceColor(String pieceId, String expectedColor, Boolean isValid) {
    apply(new ValidatedPieceColor(pieceId, expectedColor, isValid));
  }

  public void validatePieceType( String pieceId, String expectedType, Boolean isValid) {
    apply(new ValidatedPieceType( pieceId, expectedType, isValid));
  }
  public void updateBox(Integer row, String column, String piece) {
      apply(new UpdatedBox(row, column, piece));
  }
  public void recordMovement(String movementId) {
      apply(new RecordedMovement(movementId));
  }
  public void endGame(String winnerId, String loserId) {
    apply(new GameEnded(winnerId, loserId));
  }
  public void validateMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId) {
    apply(new ValidatedMovement(idMovement, idPlayer, row, column, pieceId));
  }
  public void executeMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId) {
    apply(new ExecutedMovement(idMovement, idPlayer, row, column, pieceId));
  }
  public void inValidateMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId, String reason) {
    apply(new InvalidMovement(idMovement, idPlayer, row, column, pieceId, reason));
  }
  public void updatedMovement(String idMovement, String idPlayer, Integer row, String column, String pieceId) {
    apply(new UpdatedMovement(idMovement, idPlayer, row, column, pieceId));
  }
  //endregion
  //region Methods
  public static Movement from(final String identity, final List<DomainEvent> events) {
    Movement movement = new Movement(MovementId.of(identity));
    events.forEach(movement::apply);
    return movement;
  }
  //endregion
  //region Helpers
  public void messageMovementInvalid(String mensaje) {
    if (mensaje != null) {
     System.out.println(mensaje);
    }
  }
 //endregion
}
