package com.buildingblocks.movementsandtactics.domain.movements;

import com.buildingblocks.domain.shared.domain.generic.AggregateRoot;
import com.buildingblocks.movementsandtactics.domain.movements.entities.BoardStatus;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;
import com.buildingblocks.movementsandtactics.domain.movements.events.AdvancedBox;
import com.buildingblocks.movementsandtactics.domain.movements.events.AssignedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.ChangedShift;
import com.buildingblocks.movementsandtactics.domain.movements.events.MovedPiece;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.MovementId;
import com.buildingblocks.movementsandtactics.domain.movements.values.PositionPiece;


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
    apply(new AssignedShift(shift.getIdentity(), idPlayer, shift.getCurrentShift()));
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
  public void assignShiftToPlayer(Integer playerId, CurrentShift shiftNumber) {
    shift.assign(playerId.toString(), shiftNumber.getNumberShift());
    apply(new AssignedShift(shift.getIdentity(), playerId, CurrentShift.of(shiftNumber.getNumberShift())));
  }
  public void changeShift(Integer previousPlayerId, Integer newPlayerId, Integer shiftNumber) {
    shift.change(newPlayerId.toString(), shiftNumber);
    apply(new ChangedShift(previousPlayerId, newPlayerId));
  }
  public void movePiece(Integer playerId, Integer pieceId, PositionPiece positionInitial, PositionPiece positionFinal) {
    if (pieceMovement != null) {
      pieceMovement.move(positionFinal.getPositionFinal());
      apply(new MovedPiece(playerId, pieceId, positionInitial, positionFinal));
    }
  }
  public void advancePiece(PositionPiece positionPiece) {
    if (boardStatus != null) {
      boardStatus.advanceBox(positionPiece);
      apply(new AdvancedBox(
        positionPiece.getPositionFinal().getRow(),
        positionPiece.getPositionFinal().getColumn(),
        pieceMovement.getIdentity().toString(),
        idPlayer
      ));
    }
  }

  //endregion
}
