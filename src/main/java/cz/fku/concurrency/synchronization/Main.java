package cz.fku.concurrency.synchronization;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Statistic statistic = new Statistic();
        Task task = new Task(statistic);

        int processors = Runtime.getRuntime().availableProcessors();
        List<Thread> threads = new ArrayList<>(processors);
        for (int i =0; i < processors; i++) {
            Thread thread = new Thread(task);
            threads.add(thread);
            System.out.println("Starting thread: " + thread.getName());
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Resulting statistic is: %d\n", statistic.getStatistic());
        System.out.printf("Total count %d\n\n", statistic.getTotal());
    }
}
