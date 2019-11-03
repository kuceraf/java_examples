package cz.fku.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedCaptures {
    private static String PATTERN_STR =
                    "(?<CMD> put|get)\\s+" + // capture group 1 is saved to CMD - put or get followed by one or more space
                    "(?<TYPE>files|buffers)\\s+in\\s+" +
                    "(?<TARG>\\w+)";
    public static void main(String[] args) {
        String text = "put files in test_dir";
        Matcher matcher = Pattern.compile(PATTERN_STR, Pattern.COMMENTS) //
                .matcher(text);
        while (matcher.find()) {
            System.out.println("Groups: " + matcher.groupCount());
            System.out.println("CMD: " + matcher.group("CMD"));
            System.out.println("TYPE: " + matcher.group("TYPE"));
            System.out.println("TARG: " + matcher.group("TARG"));
        }
    }
}
