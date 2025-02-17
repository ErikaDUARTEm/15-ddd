package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class Description implements IValueObject {
  private final String text;

  private Description(String text) {
    this.text = text;
    validate();
  }
  public static Description of(String text){
    return new Description(text);
  }
  @Override
  public void validate() {
    validateNotNull(text);
    validateNotEmpty(text);
  }

  public String getText() {
    return text;
  }
}
