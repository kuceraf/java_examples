package cz.fku.concurrency;

import org.w3c.dom.events.EventListener;

import java.util.ArrayList;

import java.util.List;

public class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void registerListener(EventListener eventListener) {
        listeners.add(eventListener);
    }
}
