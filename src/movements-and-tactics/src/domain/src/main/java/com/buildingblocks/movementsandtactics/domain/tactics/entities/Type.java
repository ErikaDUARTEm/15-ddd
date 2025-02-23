package com.buildingblocks.movementsandtactics.domain.tactics.entities;

import com.buildingblocks.domain.shared.domain.generic.Entity;
import com.buildingblocks.domain.shared.domain.utils.TypePiece;
import com.buildingblocks.movementsandtactics.domain.movements.entities.PieceMovement;
import com.buildingblocks.movementsandtactics.domain.tactics.values.Description;
import com.buildingblocks.movementsandtactics.domain.tactics.values.Name;
import com.buildingblocks.movementsandtactics.domain.tactics.values.PiecesInvolved;
import com.buildingblocks.movementsandtactics.domain.tactics.values.TypeId;
import com.buildingblocks.movementsandtactics.domain.tactics.values.TypeTactic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Type extends Entity<TypeId> {
  private Name name;
  private Description description;
  private final Map<String, Function<List<PieceMovement>, Boolean>> specificConditions;
  private List<PiecesInvolved> piecesInvolved;

  //region Constructors
  public Type(TypeId identity, Name name, Description description, Map<String, Function<List<PieceMovement>, Boolean>> specificConditions, List<PiecesInvolved> piecesInvolved) {
    super(identity);
    this.name = name;
    this.description = description;
    this.specificConditions = new HashMap<>();
    initializeSpecificConditions();
    this.piecesInvolved = piecesInvolved;
  }
  public Type(Name name, Description description, Map<String, Function<List<PieceMovement>, Boolean>> specificConditions, List<PiecesInvolved> piecesInvolved) {
    super(new TypeId());
    this.name = name;
    this.description = description;
    this.specificConditions = new HashMap<>();
    initializeSpecificConditions();
    this.piecesInvolved = piecesInvolved;
  }

//endregion
//region Getters and Setters

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Description getDescription() {
    return description;
  }

  public void setDescription(Description description) {
    this.description = description;
  }


  public List<PiecesInvolved> getPiecesInvolved() {
    return piecesInvolved;
  }

  public void setPiecesInvolved(List<PiecesInvolved> piecesInvolved) {
    this.piecesInvolved = piecesInvolved;
  }
  public Map<String, Function<List<PieceMovement>, Boolean>> getSpecificConditions() {
    return specificConditions;
  }
//endregion
//region Methods
  public boolean isPieceInvolved(PiecesInvolved piece) {
    return piecesInvolved.contains(piece);
  }
  private void initializeSpecificConditions() {
    specificConditions.put(TypeTactic.ENROQUE.toString(), this::evaluateCastlingCondition);
  }
  private boolean evaluateCastlingCondition(List<PieceMovement> pieces) {
    PieceMovement king = pieces.stream().filter(p -> p.getPieceType().getType().equals(TypePiece.KING)).findFirst().orElse(null);
    PieceMovement rook = pieces.stream().filter(p -> p.getPieceType().getType().equals(TypePiece.ROOK)).findFirst().orElse(null);

    return king != null && rook != null && king.getCurrentBox().getRow().equals(rook.getCurrentBox().getRow());
  }


//endregion

}
