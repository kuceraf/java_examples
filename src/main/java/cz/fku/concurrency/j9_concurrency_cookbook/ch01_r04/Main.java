package cz.fku.concurrency.j9_concurrency_cookbook.ch01_r04;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(8);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
    }
}
