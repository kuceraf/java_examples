package cz.fku.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Performance {
    private static String PATTERN_STR_1 = "<(?:\\d+,)*\\d+>"; // NOT OPTIMAL - lot of backtracking
    private static String PATTERN_STR_2 = "<\\d+(?:,\\d+)*>";
    public static void main(String[] args) {
        String text_input = "<3,4345,23>";
        Matcher matcher = Pattern.compile(PATTERN_STR_2, Pattern.COMMENTS)
                .matcher(text_input);

        int i = 0;
        while (matcher.find()) {
            System.out.println(i);
            System.out.println(matcher.group(0));
            i++;
        }
    }
}
