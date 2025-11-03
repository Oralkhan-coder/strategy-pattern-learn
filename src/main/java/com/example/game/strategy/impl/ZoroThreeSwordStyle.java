package main.java.com.example.game.strategy.impl;

import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class ZoroThreeSwordStyle implements AttackStrategy {
    @Override
    public String getName() {
        return "Three-Sword Style";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 22;
        target.takeDamage(attacker, damage, "unleashes a Three-Sword Style slash");
    }
}


