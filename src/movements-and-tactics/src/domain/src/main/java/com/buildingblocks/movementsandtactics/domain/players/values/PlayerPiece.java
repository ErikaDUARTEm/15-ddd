package com.buildingblocks.movementsandtactics.domain.players.values;

import com.buildingblocks.domain.shared.domain.generic.IValueObject;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateColor;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotEmpty;
import static com.buildingblocks.domain.shared.domain.utils.Validate.validateNotNull;

public class PlayerPiece implements IValueObject {
  private final String pieceId;
  private final String color;
  private final String type;

  private PlayerPiece(String pieceId, String color, String type) {
    this.pieceId = pieceId;
    this.color = color;
    this.type = type;
    validate();
  }
  public static PlayerPiece of(String pieceId, String color, String type){
    return new PlayerPiece(pieceId, color, type);
  }

  @Override
  public void validate() {
    validateNotEmpty(pieceId, "pieceId cannot be empty");
    validateNotNull(color, "color cannot be null");
    validateNotEmpty(color, "color cannot be empty");
    validateColor(color);
    validateNotEmpty(type, "type cannot be empty");
    validateNotNull(type, "type cannot be null");
  }

  public String getColor() {
    return color;
  }

  public String getType() {
    return type;
  }

  public String getPieceId() {
    return pieceId;
  }
}
