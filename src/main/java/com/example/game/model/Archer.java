package main.java.com.example.game.model;


import main.java.com.example.game.strategy.AttackStrategy;
import main.java.com.example.game.strategy.impl.RangedAttack;

public class Archer extends Hero {
    public Archer(String name) {
        this(name, 90, new RangedAttack());
    }

    public Archer(String name, int health, AttackStrategy initialStrategy) {
        super(name, health, initialStrategy);
    }
}


