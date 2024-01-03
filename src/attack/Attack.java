package attack;

import player.Player;

public interface Attack {

    String getName();
    String getStatsAsString();

    void execute(Player from, Player onTo) throws InvalidAttackException;

}
