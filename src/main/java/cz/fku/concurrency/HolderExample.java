package cz.fku.concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HolderExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            HolderExample.sieveOfEratosthenes(1000000000);
        });

        Thread thread2 = new Thread(() -> {
            HolderExample.sieveOfEratosthenes(1000000000);
        });

        thread1.start();
        thread2.start();

    }

    private class Holder {
        private int n;
        public Holder(int n) {
            this.n = n;
        }
        public void printValue() {
            System.out.println(n);
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
