package cz.fku.concurrency.j9_concurrency_cookbook.ch01_r04;

import java.util.concurrent.TimeUnit;

public class ConsoleClock implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            try {

                System.out.println("Iteration no: " + i);
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }
}
