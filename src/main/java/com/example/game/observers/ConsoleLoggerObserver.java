package main.java.com.example.game.observers;


import main.java.com.example.game.observer.HeroEvent;
import main.java.com.example.game.observer.HeroObserver;

public class ConsoleLoggerObserver implements HeroObserver {
    @Override
    public void onEvent(HeroEvent event) {
        System.out.println("[LOG] " + event.getType() + ": " + event.getMessage());
    }
}


