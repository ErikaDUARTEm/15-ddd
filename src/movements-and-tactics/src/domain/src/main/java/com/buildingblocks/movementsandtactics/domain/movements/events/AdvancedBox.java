package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class AdvancedBox extends DomainEvent {
  private final Integer row;
  private final String column;
  private final String pieceId;
  private final String type;
  private final String color;

  public AdvancedBox(Integer row, String column, String pieceId, String type, String color) {
    super(EventsEnum.ADVANCED_BOX.name());
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
    this.type = type;
    this.color = color;
  }

  public Integer getRow() {
    return row;
  }

  public String getColumn() {
    return column;
  }

  public String getPieceId() {
    return pieceId;
  }
  public String getType() {
    return type;
  }

  public String getColor() {
    return color;
  }
}
