package com.buildingblocks.movementsandtactics.domain.movements.events;

import com.buildingblocks.domain.shared.domain.generic.DomainEvent;


public class AdvancedBox extends DomainEvent {
  private Integer row;
  private String column;
  private String pieceId;
  private String type;
  private String color;

  public AdvancedBox(Integer row, String column, String pieceId, String type, String color) {
    super(EventsEnum.ADVANCED_BOX.name());
    this.row = row;
    this.column = column;
    this.pieceId = pieceId;
    this.type = type;
    this.color = color;
  }
  public AdvancedBox(){}
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

  public void setRow(Integer row) {
    this.row = row;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public void setPieceId(String pieceId) {
    this.pieceId = pieceId;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
