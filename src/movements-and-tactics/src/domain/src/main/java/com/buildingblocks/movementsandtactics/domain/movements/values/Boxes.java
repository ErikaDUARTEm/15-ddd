package com.buildingblocks.movementsandtactics.domain.movements.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;


public class Boxes  implements IValueObject {
  private final List<Box> boxes;

  private Boxes(List<Box> boxes) {
    this.boxes = boxes;
    validate();
  }

  public static Boxes of(List<Box> boxes){
    return new Boxes(boxes);
  }

  @Override
  public void validate() {
    for (Box box : boxes) {
      validateNotNull(box.toString(), "box cannot be null");
      validateNotEmpty(box.toString(), "box cannot be empty");
    }
  }

  public List<Box> getBoxes() {
    return boxes;
  }
}
