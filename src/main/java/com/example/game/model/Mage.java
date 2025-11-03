package main.java.com.example.game.model;


import main.java.com.example.game.strategy.AttackStrategy;
import main.java.com.example.game.strategy.impl.MagicAttack;

public class Mage extends Hero {
    public Mage(String name) {
        this(name, 80, new MagicAttack());
    }

    public Mage(String name, int health, AttackStrategy initialStrategy) {
        super(name, health, initialStrategy);
    }
}


