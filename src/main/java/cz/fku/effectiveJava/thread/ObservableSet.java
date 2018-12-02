package cz.fku.effectiveJava.thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Broken - invokes alien method from synchronized block!
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) { super(set); }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized (observers) {
            observers.forEach((observer -> observer.added(this, element)));
        }
    }

    @Override
    public boolean add(E e) {
        boolean isAdded = super.add(e);
        if (isAdded)
            notifyElementAdded(e);

        return isAdded;
    }
}
