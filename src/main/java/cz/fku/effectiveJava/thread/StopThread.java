package cz.fku.effectiveJava.thread;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private static synchronized boolean isStopRequested() {
        return  stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroudThread = new Thread(() -> {
            int i = 0;
            while (!isStopRequested()) {
                i++;
                System.out.println("i: " + i);
            }
        });


        backgroudThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
