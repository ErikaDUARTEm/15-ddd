package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

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
  public List<String> validate() {
    validateNotNull(text, "text cannot be null");
    validateNotEmpty(text, "text cannot be empty");
    return null;
  }

  public String getText() {
    return text;
  }
}
