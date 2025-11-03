package main.java.com.example.game.observer;


import main.java.com.example.game.model.Hero;

public class HeroEvent {
    private final EventType type;
    private final Hero source;
    private final Hero target;
    private final String message;
    private final int value;

    public HeroEvent(EventType type, Hero source, Hero target, String message, int value) {
        this.type = type;
        this.source = source;
        this.target = target;
        this.message = message;
        this.value = value;
    }

    public EventType getType() {
        return type;
    }

    public Hero getSource() {
        return source;
    }

    public Hero getTarget() {
        return target;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }
}


