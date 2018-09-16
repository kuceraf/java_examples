package cz.fku.effectiveJava.method;

import java.math.BigInteger;
import java.util.Objects;

public class NotNull {
    public static void main(String[] args) {
        compute(null);
    }

    public static void compute(BigInteger i) {
        Objects.requireNonNull(i, "i must not be null");
    }
}
