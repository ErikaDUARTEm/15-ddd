package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.PlayerId;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class Shift extends Entity<ShiftId> {
  private final PlayerId playerId;
  private CurrentShift currentShift;
  private ShiftHistory history;

  //region Constructors
  public Shift(ShiftId identity, PlayerId playerId, CurrentShift currentShift, ShiftHistory history) {
    super(identity);
    this.playerId = playerId;
    this.currentShift = currentShift;
    this.history = history;

  }
  public Shift(PlayerId playerId, CurrentShift currentShift) {
    super(new ShiftId());
    this.playerId = playerId;
    this.currentShift = currentShift;

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
   public void assign(PlayerId idPlayer, ShiftId shiftIdNew) {
    validateNotEmpty(String.valueOf(idPlayer), "idPlayer cannot be empty");
    validateNotNull(idPlayer, "idPlayer cannot be null");
    validateNotEmpty(String.valueOf(shiftIdNew), "numberShift cannot be empty");
    validateNotNull(String.valueOf(shiftIdNew), "numberShift cannot be null");
    if (currentShift == null) {
      currentShift = CurrentShift.of(String.valueOf(shiftIdNew));
      return;
    }
    if (currentShift.getNumberShift().equals(shiftIdNew.getValue())) {
      return;
    }
    currentShift = CurrentShift.of(String.valueOf(shiftIdNew));
  }

  public  void record(){
    validateNotNull(currentShift, "currentShift cannot be null");
    history = history.addShift(currentShift);
    currentShift = null;
  }
  public void change(PlayerId idPlayerNew, ShiftId numberShiftNew) {
    record();
    assign(idPlayerNew, numberShiftNew);
  }
  public void endShift(){
    record();
    currentShift = null;
  }
  //endregion
}
