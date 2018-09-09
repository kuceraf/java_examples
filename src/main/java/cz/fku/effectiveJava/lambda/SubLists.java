package cz.fku.effectiveJava.lambda;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(
                Stream.of(Collections.emptyList()),
                prefixes(list)
                        // from stream input element eg.: [a, b, c]
                        // it generates stream of this elements [a, b, c], [b, c], [c] (resulted stream of elements)
                        // all resulted strems of elements are then flattened to single stream
                        .flatMap((SubLists::suffixes))
        );
    }

    /* From list input eg [a, b, c, d] it gradually generate stream with elements:
     * [a], [a, b], ..., [a, b, c, d]
     *
     */
    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    /*
     * Create all suffixes of given list eg.:
     * [a] -> [a]
     * [a, b] -> [a, b], [b]
     * [a, b, c] -> [a, b, c], [b, c], [c]
     * [a, b, c, d] -> [a, b, c, d], [b, c, d], [c, d], [d]
     */
    private static <E> Stream<List<E>> suffixes(List<E> list) {
        System.out.println("Suffixes from: " + list);
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()))
                .peek(System.out::println);
    }
}
