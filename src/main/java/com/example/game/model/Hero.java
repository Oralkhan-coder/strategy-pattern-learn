package main.java.com.example.game.model;


import main.java.com.example.game.observer.EventType;
import main.java.com.example.game.observer.HeroEvent;
import main.java.com.example.game.observer.HeroObserver;
import main.java.com.example.game.strategy.AttackStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hero {
    private final String name;
    private int health;
    private final int maxHealth;
    private AttackStrategy attackStrategy;
    private final List<HeroObserver> observers;

    protected Hero(String name, int health, AttackStrategy initialStrategy) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackStrategy = initialStrategy;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy newStrategy) {
        this.attackStrategy = newStrategy;
        notifyObservers(new HeroEvent(
            EventType.STRATEGY_CHANGED,
            this,
            null,
            name + " switched to " + newStrategy.getName() + " attack",
            0
        ));
    }

    public void attack(Hero target) {
        if (!isAlive()) {
            return;
        }
        if (target == null || !target.isAlive()) {
            return;
        }
        notifyObservers(new HeroEvent(
            EventType.ATTACK,
            this,
            target,
            name + " uses " + attackStrategy.getName() + " attack",
            0
        ));
        attackStrategy.attack(this, target);
    }

    public void takeDamage(Hero attacker, int amount, String flavor) {
        if (!isAlive()) {
            return;
        }
        this.health = Math.max(0, this.health - amount);
        notifyObservers(new HeroEvent(
            EventType.HEALTH_CHANGED,
            this,
            this,
            name + " " + flavor + " takes " + amount + " damage (" + health + " HP left)",
            -amount
        ));
        if (!isAlive()) {
            notifyObservers(new HeroEvent(
                EventType.HERO_DEAD,
                this,
                this,
                name + " has fallen!",
                0
            ));
        }
    }

    public void heal(Hero source, int amount, String flavor) {
        if (!isAlive()) {
            return;
        }
        int healed = Math.max(0, amount);
        int before = this.health;
        this.health = Math.min(maxHealth, this.health + healed);
        int actual = this.health - before;
        if (actual > 0) {
            notifyObservers(new HeroEvent(
                EventType.HEALTH_CHANGED,
                this,
                this,
                name + " " + flavor + " heals " + actual + " HP (" + health + " / " + maxHealth + ")",
                actual
            ));
        }
    }

    public void addObserver(HeroObserver observer) {
        if (observer == null) {
            return;
        }
        observers.add(observer);
    }

    public void removeObserver(HeroObserver observer) {
        if (observer == null) {
            return;
        }
        observers.remove(observer);
    }

    public List<HeroObserver> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    protected void notifyObservers(HeroEvent event) {
        for (HeroObserver observer : observers) {
            observer.onEvent(event);
        }
    }
}


