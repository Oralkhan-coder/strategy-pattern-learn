package main.java.com.example.game.strategy.impl;

import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class MeleeAttack implements AttackStrategy {
    @Override
    public String getName() {
        return "Melee";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 15;
        target.takeDamage(attacker, damage, "slashes with a sword");
    }
}


