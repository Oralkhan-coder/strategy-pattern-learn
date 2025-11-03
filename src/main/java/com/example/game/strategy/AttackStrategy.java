package main.java.com.example.game.strategy;

import main.java.com.example.game.model.Hero;

public interface AttackStrategy {
    String getName();

    void attack(Hero attacker, Hero target);
}


