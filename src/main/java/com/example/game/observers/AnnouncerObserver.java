package main.java.com.example.game.observers;


import main.java.com.example.game.observer.HeroEvent;
import main.java.com.example.game.observer.HeroObserver;

public class AnnouncerObserver implements HeroObserver {
    @Override
    public void onEvent(HeroEvent event) {
        switch (event.getType()) {
            case ATTACK:
                System.out.println("[ANNOUNCER] " + event.getSource().getName() + " attacks " + event.getTarget().getName() + "! " + event.getMessage());
                break;
            case HEALTH_CHANGED:
                System.out.println("[ANNOUNCER] " + event.getMessage());
                break;
            case HERO_DEAD:
                System.out.println("[ANNOUNCER] " + event.getSource().getName() + " is defeated!");
                break;
            case STRATEGY_CHANGED:
                System.out.println("[ANNOUNCER] " + event.getMessage());
                break;
            default:
                System.out.println("[ANNOUNCER] " + event.getMessage());
        }
    }
}


