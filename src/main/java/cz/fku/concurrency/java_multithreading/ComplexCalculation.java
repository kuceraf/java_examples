package cz.fku.concurrency.java_multithreading;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ComplexCalculation {
    public static void main(String[] args) {
        ComplexCalculation complexCalculation = new ComplexCalculation();
        BigInteger calculateResult = complexCalculation.calculateResult(
                BigInteger.valueOf(2),
                BigInteger.valueOf(10),
                BigInteger.valueOf(2),
                BigInteger.valueOf(10)
        );
        System.out.println("ComplexCalculation completed. Final result is: " + calculateResult);
        System.out.println("Main end");
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread worker1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread worker2 = new PowerCalculatingThread(base2, power2);
        worker1.start();
        worker2.start();
        try {
            worker1.join(5000);
            worker1.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return worker1.result.add(worker2.result);
    }

    private static class PowerCalculatingThread extends Thread {

        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0;  i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            System.out.println(this.getName() + " base: "+ base + "power: " + power + " result: " + result);
        }

        public BigInteger getResult() { return result; }
    }
}
