package com.buildingblocks.domain.shared.domain.utils;

public class Validate {

  public static void validateNotNull(Object objectValue, String message) {
    if (objectValue == null) {
      throw new IllegalArgumentException(message);
    }
  }

  public static void validateNotEmpty(String objectValue, String message) {
    if (objectValue.isEmpty()) {
      throw new IllegalArgumentException(message);
    }
  }
  public static void validateColor(String color){
    if (!color.matches("WHITE|BLACK")) {
         throw new IllegalArgumentException("Invalid color");
      }
  }
}