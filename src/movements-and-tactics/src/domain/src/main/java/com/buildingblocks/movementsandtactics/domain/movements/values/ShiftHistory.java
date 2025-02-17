package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class ShiftHistory implements IValueObject {
  private final List<CurrentShift> shifts;

  private ShiftHistory(List<CurrentShift> shifts) {
    this.shifts = new ArrayList<>(shifts);
    validate();
  }
  public static ShiftHistory of(List<CurrentShift> shifts){
    return new ShiftHistory(shifts);
  }
  @Override
  public void validate() {
    for (CurrentShift shift : shifts) {
      validateNotNull(shift.toString());
      validateNotEmpty(shift.toString());
    }
  }
  public void addShift(CurrentShift newShift) {
    shifts.add(newShift);
  }

  public List<CurrentShift> getShifts() {
    return shifts;
  }
}
