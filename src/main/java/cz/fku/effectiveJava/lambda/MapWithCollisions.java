package cz.fku.effectiveJava.lambda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toMap;

public class MapWithCollisions {
    // this function combine all values associated with the same key
    private static BinaryOperator<String> mergeFun1 = (String existingValue, String newValue) -> {
        StringBuilder stringBuilder = new StringBuilder(existingValue);
        stringBuilder.append(", ");
        return stringBuilder.append(newValue).toString();
    };

    // this function replace oldValue by newValue
    private static BinaryOperator<String> mergeFun2 =  (String existingValue, String newValue) -> {
        return newValue;
    };

    public static void main(String[] args) throws FileNotFoundException {
        try (Stream<String> words = new Scanner(loadFile()).tokens()) {
            words.collect(toMap(String::length, word->word, mergeFun1))
            .forEach((key, value) ->
                    System.out.printf("Key is: %s, value is: %s%n", key, value));
        }
    }

    private static File loadFile() {
        String fileStr = WordFrequency.class.getResource("/words.txt").getFile();
        return new File(fileStr);
    }
}
