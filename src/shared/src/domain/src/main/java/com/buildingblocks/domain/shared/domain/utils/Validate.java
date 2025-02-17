package com.buildingblocks.domain.shared.domain.utils;

public class Validate {

  public static void validateNotNull(String objectValue) {
    if (objectValue == null) {
      throw new IllegalArgumentException("cannot be null");
    }
  }

  public static void validateNotEmpty(String objectValue) {
    if (objectValue.isEmpty()) {
      throw new IllegalArgumentException("cannot be empty");
    }
  }
  public static void validateColor(String color){
    if (!color.matches("blanco|negro")) {
         throw new IllegalArgumentException("Invalid color");
      }
  }
}