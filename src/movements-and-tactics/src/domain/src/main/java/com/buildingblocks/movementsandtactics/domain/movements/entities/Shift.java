package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.shared.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

import java.util.ArrayList;
import java.util.List;


import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class Shift extends Entity<ShiftId> {
  private PlayerId playerId;
  private CurrentShift currentShift;
  private ShiftHistory history;

  //region Constructors
  public Shift(ShiftId identity, PlayerId playerId, CurrentShift currentShift, ShiftHistory history) {
    super(identity);
    this.playerId = playerId;
    this.currentShift = currentShift;
    this.history = history != null ? history :ShiftHistory.of(List.of());

  }
  public Shift(PlayerId playerId, CurrentShift currentShift) {
    super(new ShiftId());
    this.playerId = playerId;
    this.currentShift = currentShift;
    this.history = ShiftHistory.of(List.of());
  }
 //endregion
  //region Getters and Setters
  public CurrentShift getCurrentShift() {
    return currentShift;
  }

  public void setCurrentShift(CurrentShift currentShift) {
    this.currentShift = currentShift;
  }

  public ShiftHistory getHistory() {
    return history;
  }

  public void setHistory(ShiftHistory history) {
    this.history = history;
  }
  public PlayerId getPlayerId() {
    return playerId;
  }
  //endregion
  //region Methods
   public void assign( String shiftIdNew,PlayerId idPlayer) {
     validateNotEmpty(idPlayer.getValue(), "idPlayer cannot be empty");
     validateNotNull(idPlayer, "idPlayer cannot be null");
     validateNotEmpty(shiftIdNew, "numberShift cannot be empty");
     validateNotNull(shiftIdNew, "numberShift cannot be null");

     this.playerId = PlayerId.of(idPlayer.getValue());
     setCurrentShift(CurrentShift.of(shiftIdNew, playerId.getValue()));
  }

  public  void record(String playerId, String shiftId){
    setCurrentShift(CurrentShift.of(shiftId, playerId));
    validateNotNull(currentShift, "currentShift cannot be null");
    addShift(currentShift);
   // currentShift = null;
  }
  public void change(PlayerId idPlayerNew, String numberShiftNew) {
    CurrentShift newCurrentShift = CurrentShift.of(numberShiftNew, idPlayerNew.getValue());
    setCurrentShift(newCurrentShift);
    this.playerId = idPlayerNew;
    addShift(newCurrentShift);
  }
  public void addShift(CurrentShift newShift) {
    List<CurrentShift> updatedShifts = new ArrayList<>(history.getShifts());
    updatedShifts.add(newShift);
    this.history = ShiftHistory.of(updatedShifts);
  }
  public void endShift(String playerId) {
    if (currentShift == null) {
      throw new IllegalStateException("No hay turno activo para terminar.");
    }
    if (currentShift.getPlayerId().equals(playerId)) {
      throw new IllegalArgumentException("Este jugador no tiene el turno actual.");
    }
    record(playerId, currentShift.getNumberShift());
    currentShift = null;
  }
  //endregion
}
