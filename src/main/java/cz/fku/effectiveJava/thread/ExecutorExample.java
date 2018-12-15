package cz.fku.effectiveJava.thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<List<Integer>> task1 = () -> ExecutorExample.sieveOfEratosthenes(1000000000);
        Callable<List<Integer>> task2 = () -> ExecutorExample.sieveOfEratosthenes(1000000000);
        Callable<List<Integer>> task3 = () -> ExecutorExample.sieveOfEratosthenes(1000000000);
        try {
            List<Future<List<Integer>>> futures = executorService.invokeAll(List.of(task1, task2, task3));
            futures.forEach(f -> {
//                f.get()
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + " prime " + i);
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
