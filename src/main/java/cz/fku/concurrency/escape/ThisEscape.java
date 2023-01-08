package cz.fku.concurrency.escape;

import java.util.Date;

class Event { }
interface EventListener {
    public void onEvent(Event e);
}
public class ThisEscape {
    private final int num;

    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {
                    public void onEvent(Event e) {
                        doSomething(e);
                    }
                });
        num = 42;
    }

    private void doSomething(Event e) {
        if (num != 42) {
            System.out.println("Race condition detected at " +
                    new Date());
        }
    }
}
