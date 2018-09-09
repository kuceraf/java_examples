package cz.fku.effectiveJava.lambdas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    private BiFunction<Integer, Integer, Integer> remappingFun = (oldValue, value) -> Integer.sum(oldValue, value);
    @Test
    public void merge() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.merge("A", 1, remappingFun);
        Assertions.assertThat(hashMap.get("A")).isEqualTo(1);
        hashMap.merge("A", 1, remappingFun);
        Assertions.assertThat(hashMap.get("A")).isEqualTo(2);
        hashMap.merge("A", 2, remappingFun);
        Assertions.assertThat(hashMap.get("A")).isEqualTo(4);
    }

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
