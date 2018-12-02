package cz.fku.effectiveJava.thread;

import org.assertj.core.internal.Integers;
import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ObservableSetTest {

    @Test
    public void testObservableSet() {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        observableSet.addObserver((set, element) -> {
            System.out.println("Adding element:" + element);
            System.out.println("Set size:" + set.size());
        });

        IntStream.rangeClosed(0, 100).forEach(observableSet::add);
    }

    @Test
    public void testObservableSet2() {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        observableSet.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println("Adding element:" + element);
                System.out.println("Set size:" + set.size());

                if (element == 23)
                    set.removeObserver(this);
            }
        });

        IntStream.rangeClosed(0, 100).forEach(observableSet::add);
    }

    @Test
    public void testObservableSet3() {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        observableSet.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println("Adding element:" + element);
                System.out.println("Set size:" + set.size());

                if (element == 23) {
                    ExecutorService exec =
                            Executors.newSingleThreadExecutor();

                    try {
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        IntStream.rangeClosed(0, 100).forEach(observableSet::add);
    }
}