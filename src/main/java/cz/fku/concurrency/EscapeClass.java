package cz.fku.concurrency;


public class EscapeClass {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        EscapeClass escapeClass = new EscapeClass(eventSource);
    }

    public EscapeClass(EventSource eventSource) {
        eventSource.registerListener(evt -> System.out.println("Event: " + evt));
    }
}
