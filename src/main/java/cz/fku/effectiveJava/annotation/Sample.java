package cz.fku.effectiveJava.annotation;

public class Sample {
    @CustomTest
    public static void testMethod() {
        System.out.println("test something");
    }

    @CustomTest
    public static void testMethodFail() {
        throw new RuntimeException("Fail while testing");
    }

    @CustomExceptionTest(ArithmeticException.class)
    public static  void testMethodException() {
        int a = 2;
        int b = 0;
        long c = a / b;
    }
}
