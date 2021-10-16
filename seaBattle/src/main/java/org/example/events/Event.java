package org.example.events;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final List<Runnable> subscribers = new ArrayList<>();

    public void subscribe(Runnable subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Runnable subscriber) {
        subscribers.remove(subscriber);
    }

    public void trigger() {
        for (var sub : subscribers) {
            sub.run();
        }
    }
}
