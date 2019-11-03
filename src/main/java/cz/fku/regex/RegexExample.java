package cz.fku.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        run5();
    }

    public static void run() {
        String[] words = {"a","ab","ac","abc","aac","aa"};
        for(String str:words)   {
            if(str.matches("[abc]"))  {
                System.out.println(str);
            }
        }
    }

    public static void run2() {
        Pattern pattern = Pattern.compile("A.+a");
        String text = "Fred Anna Alexander";
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.find());
        System.out.println(text.substring(matcher.start(), matcher.end()));
    }

    public static void run3() {
        Pattern pattern = Pattern.compile("A.+a");
        Matcher matcher = pattern.matcher("Anna Alexa");
        System.out.println(matcher.matches());
        System.out.println(matcher.group());
    }

    public static void run4() {
        Pattern pattern = Pattern.compile("[abc]");
        Matcher matcher = pattern.matcher("bca");
        System.out.println(matcher.groupCount());
//        System.out.println(matcher.group());
    }

    static void run5() {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
