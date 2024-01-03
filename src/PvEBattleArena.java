import player.Player;
import player.CPU;
import attack.InvalidAttackException;
import attack.Attack;

import java.util.Scanner;

public class PvEBattleArena {

    private Scanner scanner;
    private Player player;
    private CPU cpu;

    public void fight() {
        while(true) {
            displayRoundInfo();
            System.out.println("Your turn");
            if (player.kp > 0) {
                displayPlayerAttacks();
                selectAndExecuteAttack();
            } else {
                System.out.println("You loose...");
                break;
            }
            System.out.println("Enemy turn");
            if (cpu.kp > 0) {
                cpu.attack(player);
            } else {
                System.out.println("You Win!");
                break;
            }
        }
    }

    private void displayRoundInfo() {
        System.out.println("Your KP: " + player.kp);
        System.out.println("Your mana: " + player.mana);
        System.out.println("Enemy KP: " + cpu.kp);
    }

    private void displayPlayerAttacks(){
        for (int i = 0; i < player.attackList.size(); i++) {
            Attack attack = player.attackList.get(i);
            System.out.println("Select " + i + " for " + attack.getName() + " deals " + attack.getStatsAsString());
        }
    }

    private void selectAndExecuteAttack() {
        while(true) {
            try {
                int attack = Integer.valueOf(scanner.nextLine());
                player.attackList.get(attack).execute(player, cpu);
                break;
            } catch (NumberFormatException | InvalidAttackException | IndexOutOfBoundsException e) {
                System.out.println("Enter a valid Attack Number");
            }
        }
    }

    public PvEBattleArena(Scanner scanner, Player player, CPU cpu) {
        this.scanner = scanner;
        this.player = player;
        this.cpu = cpu;

    }


}
