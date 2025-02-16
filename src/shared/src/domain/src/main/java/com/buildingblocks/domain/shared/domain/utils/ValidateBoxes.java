package com.buildingblocks.domain.shared.domain.utils;


public class ValidateBoxes {

  public static void validateRow(Integer row) {
    if (row == null || row < 1 || row > 8) {
      throw new IllegalArgumentException("Row must be between 1 and 8");
    }
  }

  public static void validateColumn(Column column) {
    if (column == null || !column.name().matches("[A-H]")) {
      throw new IllegalArgumentException("Column must be between A and H");
    }
  }
}
