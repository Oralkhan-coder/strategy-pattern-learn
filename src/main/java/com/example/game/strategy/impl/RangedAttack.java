package main.java.com.example.game.strategy.impl;

import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class RangedAttack implements AttackStrategy {
    @Override
    public String getName() {
        return "Ranged";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 12;
        target.takeDamage(attacker, damage, "fires an arrow");
    }
}


