package main.java.com.example.game.strategy.impl;


import main.java.com.example.game.model.Hero;
import main.java.com.example.game.strategy.AttackStrategy;

public class NamiThunderboltTempo implements AttackStrategy {
    @Override
    public String getName() {
        return "Thunderbolt Tempo";
    }

    @Override
    public void attack(Hero attacker, Hero target) {
        int damage = 18;
        target.takeDamage(attacker, damage, "casts Thunderbolt Tempo");
    }
}


