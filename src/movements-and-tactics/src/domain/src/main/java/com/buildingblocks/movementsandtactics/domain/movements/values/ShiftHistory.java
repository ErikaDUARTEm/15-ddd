package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import com.buildingblocks.movementsandtactics.domain.movements.entities.Shift;

import java.util.ArrayList;
import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class ShiftHistory implements IValueObject {
  private final List<Shift> shifts;

  private ShiftHistory(List<Shift> shifts) {
    this.shifts = new ArrayList<>(shifts);
    validate();
  }
  public static ShiftHistory of(List<Shift> shifts){
    return new ShiftHistory(shifts);
  }
  @Override
  public void validate() {
    for (Shift shift : shifts) {
      validateNotNull(shift.toString());
      validateNotEmpty(shift.toString());
    }
  }

  public List<Shift> getShifts() {
    return shifts;
  }
}
