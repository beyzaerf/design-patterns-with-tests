package com.mycompany.app.observer;

import com.mycompany.app.observer.listeners.EventListener;

import java.io.File;
import java.util.*;

public class EventManager {
    Map<String, List<com.mycompany.app.observer.listeners.EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation: operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, com.mycompany.app.observer.listeners.EventListener listener) {
        List<com.mycompany.app.observer.listeners.EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, com.mycompany.app.observer.listeners.EventListener listener) {
        List<com.mycompany.app.observer.listeners.EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<com.mycompany.app.observer.listeners.EventListener> users = listeners.get(eventType);
        for (EventListener listener: users) {
            listener.update(eventType, file);
        }
    }
}
