package attack;

import java.util.Random;
import player.Player;

public class WeaponAttack implements Attack {

    @Override
    public String getName(){
        return "Sword Attack";
    }

    @Override
    public String getStatsAsString() {
        return "damage 7 - 9";
    }

    @Override
    public void execute(Player from, Player onTo) {
        Random random = new Random();
        int dmg = 7 + random.nextInt(3);
        onTo.kp = onTo.kp - dmg;
        System.out.println(getName() + " dealt " + dmg + " damage ");
    }


}
