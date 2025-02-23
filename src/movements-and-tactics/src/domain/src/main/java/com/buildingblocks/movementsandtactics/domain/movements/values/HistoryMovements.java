package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.ArrayList;
import java.util.List;

public class HistoryMovements implements IValueObject {
  private final List<MovementId> movements;

  private HistoryMovements(final List<MovementId> movements) {
    this.movements = new ArrayList<>(movements);
    validate();
  }
  public static HistoryMovements of(List<MovementId> movements){
    return new HistoryMovements(movements);
  }
  @Override
  public void validate() {
    if (movements == null) {
      throw new IllegalArgumentException("Movements cannot be null");
    }
  }

  public List<MovementId> getMovements() {
    return movements;
  }
}
