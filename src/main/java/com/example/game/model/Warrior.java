package main.java.com.example.game.model;


import main.java.com.example.game.strategy.AttackStrategy;
import main.java.com.example.game.strategy.impl.MeleeAttack;

public class Warrior extends Hero {
    public Warrior(String name) {
        this(name, 100, new MeleeAttack());
    }

    public Warrior(String name, int health, AttackStrategy initialStrategy) {
        super(name, health, initialStrategy);
    }
}


