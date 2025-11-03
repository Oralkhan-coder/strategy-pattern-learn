package main.java.com.example.game.strategy.impl;

import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class UsopSniperShot implements AttackStrategy {
    @Override
    public String getName() {
        return "Sniper Shot";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 14;
        target.takeDamage(attacker, damage, "fires a precise sniper shot");
    }
}


