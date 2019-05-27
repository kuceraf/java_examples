package cz.fku.concurrency.synchronization;

import java.util.concurrent.TimeUnit;

public class Task  implements Runnable {
    private Statistic statistic;
    public Task(Statistic statistic) {
        this.statistic = statistic;
    }
    @Override
    public void run() {
        for (int i =0;i < 50; i++) {
            String name = Thread.currentThread().getName();
            statistic.increase(name);
            statistic.increase(name);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            statistic.decrease();
            statistic.decrease();
        }
    }
}
