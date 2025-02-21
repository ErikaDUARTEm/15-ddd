package com.buildingblocks.movementsandtactics.domain.players;

import com.buildingblocks.domain.shared.domain.generic.DomainActionsContainer;
import com.buildingblocks.domain.shared.domain.generic.DomainEvent;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerLostGame;
import com.buildingblocks.movementsandtactics.domain.players.events.PlayerWonGame;
import java.util.function.Consumer;

public class PlayerHandler extends DomainActionsContainer {

  public PlayerHandler(Player player) {
    add(wonGame(player));
    add(loseGame(player));
  }
  public Consumer<? extends DomainEvent> wonGame(Player player) {
    return (PlayerWonGame event) -> {
      if (!player.getGameEnded()) {
        player.setGameEnded(true);
        player.getStatistics().setWinCount(player.getStatistics().getWinCount() + 1);
        player.getStatistics().setGamesPlayed(player.getStatistics().getGamesPlayed() + 1);
      }
    };
  }
  public Consumer<? extends DomainEvent> loseGame(Player player){
    return (PlayerLostGame event) -> {
      if(!player.getGameEnded()){
        player.setGameEnded(true);
        player.getStatistics().setLossCount(player.getStatistics().getLossCount() + 1);
        player.getStatistics().setGamesPlayed(player.getStatistics().getGamesPlayed() + 1);
      }
    };

  }
}
