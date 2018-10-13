package cz.fku.effectiveJava.method;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        stringOpt()
                .map(String::toLowerCase)
                .ifPresent(System.out::println);
    }

    static private Optional<String> stringOpt(){
        return Optional.ofNullable(null);
    }
}
