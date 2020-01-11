package cz.fku.concurrency.phaser;

import java.util.concurrent.*;

/**
 * Phaser analogy to {@link CountDownLatch}
 * main thread will wait for all dependent services.
 *
 * Each dependent service must call {@link Phaser#arrive()} to allow main thread continue in phase 0
 *
 */
public class MyDependentServices {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser phaser = new Phaser(3);

        for(int i = 0; i < 3; i++) {
            executorService.submit(DependentService.create("S1", 10L, phaser));
            executorService.submit(DependentService.create("S2", 5L, phaser));
            executorService.submit(DependentService.create("S3", 2L, phaser));
            phaser.awaitAdvance(i); // similar to await on CountDownLatch
            System.out.println("Phase " + i + " completed");
        }

        System.out.println("All phases completed");
    }

    public static class DependentService implements Runnable{
        private Phaser phaser;
        private String serviceName;
        private Long workTime;

        private DependentService(String serviceName, Long workTime, Phaser phaser) {
            this.phaser = phaser;
            this.serviceName = serviceName;
            this.workTime = workTime;
        }

        public static DependentService create(String serviceName, Long workTime, Phaser phaser) {
            return new DependentService(serviceName, workTime, phaser);
        }

        @Override
        public void run() {
            System.out.println(serviceName + " enter run method");
            try {
                TimeUnit.SECONDS.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(serviceName + " arrive " + phaser.toString());
            phaser.arrive(); // similar to countDown on CountDownLatch
        }
    }
}
