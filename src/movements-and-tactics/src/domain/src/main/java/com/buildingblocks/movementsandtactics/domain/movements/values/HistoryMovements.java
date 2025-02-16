package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.movementsandtactics.domain.movements.Movement;

import java.util.ArrayList;
import java.util.List;

public class HistoryMovements implements IValueObject {
  private final List<Movement> movements;

  private HistoryMovements(final List<Movement> movements) {
    this.movements = new ArrayList<>(movements);
    validate();
  }
  public static HistoryMovements of(List<Movement> movements){
    return new HistoryMovements(movements);
  }
  @Override
  public void validate() {
    if (movements == null) {
      throw new IllegalArgumentException("Movements cannot be null");
    }
  }

  public List<Movement> getMovements() {
    return movements;
  }
}
