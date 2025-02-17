package com.buildingblocks.movementsandtactics.domain.tactics.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;

import java.util.List;

import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class GeneralConditions implements IValueObject {
  private final List<String> conditions;

  private GeneralConditions(final List<String> conditions) {
    this.conditions = conditions;
  }
  public static GeneralConditions of(List<String> conditions){
    return new GeneralConditions(conditions);
  }
  @Override
  public void validate() {
    for (String condition : conditions) {
      validateNotEmpty(condition);
      validateNotNull(condition);
    }
  }

  public List<String> getConditions() {
    return conditions;
  }
}
