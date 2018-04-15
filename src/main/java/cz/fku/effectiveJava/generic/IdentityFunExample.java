package cz.fku.effectiveJava.generic;

import java.util.function.UnaryOperator;

public class IdentityFunExample {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();
        sameString.apply("aaaa");
        UnaryOperator<Number> sameNumber = identityFunction();
    }
}
