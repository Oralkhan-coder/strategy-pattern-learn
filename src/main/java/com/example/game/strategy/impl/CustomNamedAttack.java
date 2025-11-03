package main.java.com.example.game.strategy.impl;


import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class CustomNamedAttack implements AttackStrategy {
    private final String name;
    private final int damage;
    private final String flavor;

    public CustomNamedAttack(String name, int damage, String flavor) {
        this.name = name;
        this.damage = Math.max(1, damage);
        this.flavor = flavor == null ? "attacks" : flavor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(attacker, damage, flavor);
    }
}


