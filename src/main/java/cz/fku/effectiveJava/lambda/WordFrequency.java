package cz.fku.effectiveJava.lambda;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class WordFrequency {
    private static Map<String, Long> freq;
    public static void main(String[] args) throws FileNotFoundException {
        try (Stream<String> words = new Scanner(loadFile()).tokens()) {
            freq = words
                    .collect(groupingBy(
                            // classification function
                            String::toLowerCase,
                            // collector implementing the downstream reduction
                            // by using the downstream collector we can apply aggregation basic in the results of the classification function.
                            counting()
                            ));
        }

        freq.forEach((key, value) -> System.out.println("word: " + key + " " + "frequency: " + value));
        topTen();
    }

    public static void topTen() {
        freq.keySet().stream()
                // comparing = comparator construction method that takes key extraction function
                .sorted(Comparator.comparing((String key) -> freq.get(key)).reversed())
                .limit(10)
                .collect(toList())
        .forEach(System.out::println);

    }

    private static File loadFile() {
        String fileStr = WordFrequency.class.getResource("/words.txt").getFile();
        return new File(fileStr);
    }
}
