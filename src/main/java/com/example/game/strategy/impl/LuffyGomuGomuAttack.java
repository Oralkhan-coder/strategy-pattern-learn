package main.java.com.example.game.strategy.impl;


import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class LuffyGomuGomuAttack implements AttackStrategy {
    @Override
    public String getName() {
        return "Gomu Gomu";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 20;
        target.takeDamage(attacker, damage, "unleashes Gomu Gomu Pistol");
    }
}


