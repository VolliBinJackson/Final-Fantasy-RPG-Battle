import player.Player;
import player.CPU;
import attack.MagicAttack;
import attack.WeaponAttack;
import attack.Attack;

import java.util.Scanner;


public class Main {

    static Player player;
    static CPU cpu;

    static {
        player = new Player();
        player.kp = 100;
        player.mana = 30;
        Attack weaponAttack = new WeaponAttack();
        Attack magicAttack = new MagicAttack();
        player.attackList.add(weaponAttack);
        player.attackList.add(magicAttack);

        cpu = new CPU();
        cpu.kp = 150;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PvEBattleArena pvEBattleArena = new PvEBattleArena(scanner, player, cpu);
        pvEBattleArena.fight();
    }

}
