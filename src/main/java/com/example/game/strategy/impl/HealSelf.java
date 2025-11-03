package main.java.com.example.game.strategy.impl;


import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class HealSelf implements AttackStrategy {
    private final int amount;

    public HealSelf() {
        this(20);
    }

    public HealSelf(int amount) {
        this.amount = amount;
    }

    @Override
    public String getName() {
        return "Heal";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        attacker.heal(attacker, amount, "uses Heal and");
    }
}


