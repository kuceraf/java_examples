package cz.fku.effectiveJava.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunCustomTest {
    public static void main(String[] args) throws Exception {
        Class<?> testClass = Class.forName(args[0]);
        int tests = 0;
        int passed = 0;


        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CustomTest.class) || method.isAnnotationPresent(CustomExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable e = wrappedExc.getCause();
                    CustomExceptionTest annotation = method.getAnnotation(CustomExceptionTest.class);
                    Class<? extends Throwable> expType = null;
                    if (annotation != null) {
                        expType = annotation.value();
                    }
                    if (expType != null && expType.isInstance(e)) {
                            passed++;

                    } else {
                        System.out.println(method + " failed: " + e);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + method);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
