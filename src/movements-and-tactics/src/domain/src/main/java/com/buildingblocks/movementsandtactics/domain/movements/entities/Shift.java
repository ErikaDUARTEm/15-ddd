package com.buildingblocks.movementsandtactics.domain.movements.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.movementsandtactics.domain.movements.values.CurrentShift;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftHistory;
import com.buildingblocks.movementsandtactics.domain.movements.values.ShiftId;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class Shift extends Entity<ShiftId> {
  private CurrentShift currentShift;
  private ShiftHistory history;
  //region Constructors
  public Shift(ShiftId identity, CurrentShift currentShift, ShiftHistory history) {
    super(identity);
    this.currentShift = currentShift;
    this.history = history;
  }
  public Shift(CurrentShift currentShift, ShiftHistory history) {
    super(new ShiftId());
    this.currentShift = currentShift;
    this.history = history;
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
  //endregion
  //region Methods
   public void assign(String idPlayer, Integer numberShift) {
    validateNotEmpty(idPlayer);
    validateNotNull(idPlayer);
    validateNotEmpty(String.valueOf(numberShift));
    validateNotNull(String.valueOf(numberShift));
    if (currentShift == null) {
      currentShift = CurrentShift.of(numberShift);
      return;
    }
    if (currentShift.getNumberShift().equals(numberShift)) {
      return;
    }
    currentShift = CurrentShift.of(numberShift);
  }

  public void record(){
    validateNotNull(currentShift.toString());
    history.addShift(currentShift);
    currentShift = null;
  }
  public void change(String idPlayerNew, Integer numberShiftNew) {
    if(currentShift != null){
      record();
    }
    assign(idPlayerNew, numberShiftNew);
  }
  //endregion
}
