package cz.fku.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BiggerIsGreaterJava {

    public static String biggerIsGreater(String w) {
        // Write your code here
        List<String> chars = new ArrayList<>();
        for (int i = 0; i < w.length(); i++) {
            chars.add(String.valueOf(w.charAt(i)));
        }

        String result = sort(chars, w.length() - 1);

        if (result.equals(w)) {
            return "no answer";
        }

        return result;
    }

    public static String sort(List<String> chars, int position) {

        if (position == 0) {
            return chars.stream().reduce("", (a, b) -> a + b);
        }

        String toCompare = chars.get(position - 1);
        Optional<String> sw = chars.subList(position, chars.size()).
                stream().filter(i -> toCompare.compareTo(i) < 0)
                .min((x, y) -> x.compareTo(y));

        if (!sw.isPresent()) {
            return sort(chars, position - 1);
        }

        List<String> subList = chars.subList(position, chars.size());
        subList.remove(sw.get());
        subList.add(toCompare);
        chars.set(position - 1, sw.get());

        return chars.subList(0, position).stream().reduce("", (a, b) -> a + b) +
                subList.stream().sorted((x, y) -> x.compareTo(y)).reduce("", (a, b) -> a + b);

    }

}
