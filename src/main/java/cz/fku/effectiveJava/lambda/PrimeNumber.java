package cz.fku.effectiveJava.lambda;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class PrimeNumber {
    /**
     * computes the number of primes less than or equal to n
     * @param n
     * @return number of primes
     */
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .peek(System.out::println)
                .count();
    }
}
