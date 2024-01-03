package player;

import attack.Attack;
import attack.InvalidAttackException;
import attack.WeaponAttack;

public class CPU extends Player {

    public void attack(Player player) {
        try {
            Attack swordAttack = new WeaponAttack();
            swordAttack.execute(this, player);
        } catch (InvalidAttackException e) {

        }

    }
}
