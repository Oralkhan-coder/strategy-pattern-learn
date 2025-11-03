package main.java.com.example.game.strategy.impl;

import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class MagicAttack implements AttackStrategy {
    @Override
    public String getName() {
        return "Magic";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 18;
        target.takeDamage(attacker, damage, "casts a fireball");
    }
}


