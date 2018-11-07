package cz.fku.effectiveJava.generalProgramming;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class ReflectionExample {
    // args: java.util.TreeSet b c a
    public static void main(String[] args) {
        Class<? extends Set<String>> clazz = null;

        try {
            clazz = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("Class not found: " + args[0]);
        }

        Constructor<? extends Set<String>> constructor = null;

        try {
            constructor = clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("No parameterless constructor");
        }

        Set<String> s = null;
        try {
            s = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}
