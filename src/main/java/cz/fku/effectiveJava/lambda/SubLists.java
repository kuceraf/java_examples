package cz.fku.effectiveJava.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    // VERSION 1
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(
                Stream.of(Collections.emptyList()),
                prefixes(list)
                        // from stream input element eg.: [a, b, c]
                        // it generates stream of this elements [a, b, c], [b, c], [c] (resulted stream of elements)
                        // all resulted strems of elements are then flattened to single stream
                        .flatMap((SubLists::suffixes)) // flatMap method is used to generate a single stream consisting of all the suffixes of all the prefixes.
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

    // VERSION 2
    public static <E> Stream<List<E>> of2 (List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()), sublists(list));
    }

    private static <E> Stream<List<E>> sublists(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> {
                    return IntStream.rangeClosed(start + 1, list.size())
                            .mapToObj(end -> list.subList(start, end))
                            .peek((newList) -> System.out.println(start + " maps to: " + newList));
                })
                .flatMap(x -> x);
    }

    // VERSION 3
    public static <E> Stream<List<E>> of3 (List<E> list) {
        List<List<E>> metaList = new ArrayList<>();
        metaList.add(Collections.emptyList());
        for(int start = 0; start < list.size(); start++) {
            for(int end = start + 1; end <= list.size(); end++) {
                List<E> subList = list.subList(start, end);
                metaList.add(subList);
                System.out.println(start + " maps to: " + subList);
            }
        }
        return metaList.stream();
    }
}
