package cz.fku.effectiveJava.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimeExecutionMeasure {
    public static void main(String[] args) throws InterruptedException {
        time(Executors.newSingleThreadExecutor(),
                5,
                () -> {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println("Foo " + name);
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Bar " + name);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
    // Simple framework for timing concurrent execution

    /**
     *
     * @param executor execute the action
     * @param concurrency number of action to be execute concurrently
     * @param action to be executed concurrently
     * @return
     * @throws InterruptedException
     */
    public static long time(Executor executor, int concurrency,

                            Runnable action) throws InterruptedException {

        CountDownLatch ready = new CountDownLatch(concurrency);

        CountDownLatch start = new CountDownLatch(1);

        CountDownLatch done  = new CountDownLatch(concurrency);



        for (int i = 0; i < concurrency; i++) {

            executor.execute(() -> {

                ready.countDown(); // Tell timer we're ready

                try {

                    start.await(); // Wait till peers are ready

                    action.run();

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                } finally {

                    done.countDown();  // Tell timer we're done

                }

            });

        }



        ready.await();     // Wait for all workers to be ready

        long startNanos = System.nanoTime();

        start.countDown(); // And they're off!

        done.await();      // Wait for all workers to finish

        return System.nanoTime() - startNanos;

    }
}
