package attack;

import player.Player;
import java.util.Random;

public class MagicAttack implements Attack {

    @Override
    public String getName() {

        return "Fireball";
    }

    @Override
    public String getStatsAsString() {
        return "damage 12 - 20, mana cost 5";
    }

    @Override
    public void execute(Player from, Player onTo) throws InvalidAttackException {
        if(from.mana >= 5) {
            from.mana -= 5;
            Random random = new Random();
            int dmg = (12 + random.nextInt(9));
            onTo.kp = onTo.kp - dmg;
            System.out.println(getName() + "dealt " + dmg + " damage");
        } else {
            throw new InvalidAttackException();
        }
    }
}
