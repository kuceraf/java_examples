package cz.fku.effectiveJava.generic;

import java.math.BigDecimal;
import java.util.*;

public class ComparableOperation {
    public static void main(String[] args){
        String[] strings = { "z", "a", "c" };
        Long[] longs = { 10L, 2L, 4L };
        List<String> stringList = Arrays.asList(strings);
        List<Long> longList = Arrays.asList(longs);
        Long maxNumber = max(longList);
        String maxString = max(stringList);
        System.out.print("Maximum string is: " + maxString);
        System.out.print("Maximum number is: " + maxNumber);

        BigDecimal[] bigDecimals = {BigDecimal.ZERO, BigDecimal.TEN};
        List<BigDecimal> bigDecimalList = Arrays.asList(bigDecimals);
        Collection<Number> unionResult = union(bigDecimalList, longList);
        System.out.print("Union result is: " + unionResult);
    }

//    The type bound <E extends Comparable<E>> may be read as “any type E that can be compared to itself,”
    private static <T extends Comparable<? super T>> T max(Collection<? extends T> collection) {
        T max = null;
        Iterator<? extends T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (max == null ||
                    (max.compareTo(next) < 0)) {
                max = next;
            }
        }
        return max;
    }

    private static <E> Collection<E> union(List<? extends E> s1, List<? extends E> s2) {
        List<E> result = new ArrayList<>();
        result.addAll(s1);
        result.addAll(s2);
        return result;
    }
}
