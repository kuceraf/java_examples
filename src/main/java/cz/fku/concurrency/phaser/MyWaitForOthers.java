package cz.fku.concurrency.phaser;

import java.util.concurrent.*;

/**
 * Phaser analogy to {@link CyclicBarrier}
 * All running {@link WaitingTask} will wait for each other to finish before continuing in execution
 *
 */
public class MyWaitForOthers {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Phaser phaser = new Phaser(3);
        executorService.submit(WaitingTask.create("S1", 10L, phaser));
        executorService.submit(WaitingTask.create("S2", 5L, phaser));
        executorService.submit(WaitingTask.create("S3", 2L, phaser));

        TimeUnit.SECONDS.sleep(15); // just to keep main thread alive
    }

    public static class WaitingTask implements Runnable {
        private Phaser phaser;
        private String serviceName;
        private Long workTime;

        private WaitingTask(String serviceName, Long workTime, Phaser phaser) {
            this.phaser = phaser;
            this.serviceName = serviceName;
            this.workTime = workTime;
        }

        public static WaitingTask create(String serviceName, Long workTime, Phaser phaser) {
            return new WaitingTask(serviceName, workTime, phaser);
        }

        @Override
        public void run() {
            System.out.println(serviceName + " enter run method");
            try {
                TimeUnit.SECONDS.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(serviceName + " complete it's work and waits for others " + phaser.toString());
            phaser.arriveAndAwaitAdvance(); // similar to barrier.await()
            System.out.println(serviceName + " all task arrived " + phaser.toString());
        }
    }
}
