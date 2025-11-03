package main.java.com.example.game;

import main.java.com.example.game.model.Archer;
import main.java.com.example.game.model.Hero;
import main.java.com.example.game.model.Mage;
import main.java.com.example.game.model.Warrior;
import main.java.com.example.game.observers.AnnouncerObserver;
import main.java.com.example.game.observers.ConsoleLoggerObserver;
import main.java.com.example.game.strategy.AttackStrategy;
import main.java.com.example.game.strategy.impl.*;

import java.util.Scanner;


public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hero Battle (Interactive) ===");
        System.out.println("Create Your Hero");
        Hero hero1 = createHero(scanner);
        System.out.println();
        Hero hero2 = new Warrior("Kaido", 250, new CustomNamedAttack("Heavy Smash", 20, "strikes ferociously"));

        ConsoleLoggerObserver logger = new ConsoleLoggerObserver();
        AnnouncerObserver announcer = new AnnouncerObserver();
        hero1.addObserver(logger);
        hero1.addObserver(announcer);
        hero2.addObserver(logger);
        hero2.addObserver(announcer);

        System.out.println();
        System.out.println("=== Battle Begins ===");

        boolean kaidoHeavyTurn = true;
        while (hero1.isAlive() && hero2.isAlive()) {
            System.out.println();
            printStatus(hero1, hero2);
            System.out.println();

            // Player turn
            System.out.println(hero1.getName() + "'s turn. Choose an attack:");
            AttackStrategy chosen = chooseStrategy(scanner);
            hero1.setAttackStrategy(chosen);
            hero1.attack(hero2);
            if (!hero2.isAlive()) {
                break;
            }

            AttackStrategy kaidoAttack = kaidoHeavyTurn
                ? new CustomNamedAttack("Heavy Smash", 20, "strikes ferociously")
                : new CustomNamedAttack("Casual Blow", 10, "swings casually");
            hero2.setAttackStrategy(kaidoAttack);
            System.out.println("Kaido prepares " + kaidoAttack.getName() + "...");
            hero2.attack(hero1);
            kaidoHeavyTurn = !kaidoHeavyTurn;
        }

        System.out.println("=== Battle Ends ===");
        System.out.println((hero1.isAlive() ? hero1.getName() : hero2.getName()) + " wins!");

        scanner.close();
    }

    private static Hero createHero(Scanner scanner) {
        System.out.print("Enter hero name: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter hero name: ");
            name = scanner.nextLine().trim();
        }
        System.out.println("Choose class: 1) Warrior  2) Mage  3) Archer");
        int cls = readIntInRange(scanner, 1, 3);
        Hero hero;
        switch (cls) {
            case 1:
                hero = new Warrior(name);
                break;
            case 2:
                hero = new Mage(name);
                break;
            default:
                hero = new Archer(name);
        }

        System.out.println("Choose starting attack (you can change each turn):");
        AttackStrategy initial = chooseStrategy(scanner);
        hero.setAttackStrategy(initial);
        return hero;
    }

    private static AttackStrategy chooseStrategy(Scanner scanner) {
        System.out.println(" 1) Melee");
        System.out.println(" 2) Ranged");
        System.out.println(" 3) Magic");
        System.out.println(" 4) Gomu Gomu (Luffy)");
        System.out.println(" 5) Three-Sword Style (Zoro)");
        System.out.println(" 6) Thunderbolt Tempo (Nami)");
        System.out.println(" 7) Sniper Shot (Usop)");
        System.out.println(" 8) Custom (name, damage, flavor)");
        System.out.println(" 9) Heal Self (+20 HP)");
        int choice = readIntInRange(scanner, 1, 9);
        switch (choice) {
            case 1:
                return new MeleeAttack();
            case 2:
                return new RangedAttack();
            case 3:
                return new MagicAttack();
            case 4:
                return new LuffyGomuGomuAttack();
            case 5:
                return new ZoroThreeSwordStyle();
            case 6:
                return new NamiThunderboltTempo();
            case 7:
                return new UsopSniperShot();
            case 8:
                return createCustomAttack(scanner);
            default:
                return new HealSelf();
        }
    }

    private static AttackStrategy createCustomAttack(Scanner scanner) {
        System.out.print("Enter custom attack name: ");
        String n = scanner.nextLine().trim();
        while (n.isEmpty()) {
            System.out.print("Name cannot be empty. Enter custom attack name: ");
            n = scanner.nextLine().trim();
        }
        System.out.print("Enter damage (1-100): ");
        int dmg = readIntInRange(scanner, 1, 100);
        System.out.print("Enter flavor text (e.g., 'launches a kick'): ");
        String flavor = scanner.nextLine().trim();
        if (flavor.isEmpty()) {
            flavor = "attacks";
        }
        return new CustomNamedAttack(n, dmg, flavor);
    }

    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            String line = scanner.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val >= min && val <= max) {
                    return val;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }
    }

    private static void printStatus(Hero a, Hero b) {
        System.out.println(a.getName() + " HP: " + a.getHealth());
        System.out.println(b.getName() + " HP: " + b.getHealth());
    }
}


