package cz.fku.effectiveJava.lambdas;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }

    @Test
    public void mersennePrimeTest() {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
}
