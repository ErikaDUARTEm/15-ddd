package com.buildingblocks.domain.shared.domain.utils;

public class Validate {

  public static void validateColorNotNull(String color) {
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null");
    }
  }

  public static void validateColorNotEmpty(String color) {
    if (color.isEmpty()) {
      throw new IllegalArgumentException("Color cannot be empty");
    }
  }
  public static void validateColor(String color){
    if (!color.matches("blanco|negro")) {
         throw new IllegalArgumentException("Invalid color");
      }
  }
}