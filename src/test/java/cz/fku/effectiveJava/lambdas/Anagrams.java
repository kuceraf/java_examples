package cz.fku.effectiveJava.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    @Test
    public void test() {
        Stream.of("ahoj", "cau", "nazdar", "uac", "auc").collect(groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= 2)
                .forEach(g -> {
                    System.out.println(g.size() + ": " + g);
                });
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);}
}
