package cz.fku.effectiveJava.thread;

@FunctionalInterface
public interface SetObserver<E> {
    void added(ObservableSet<E> set, E elemetn);
}
