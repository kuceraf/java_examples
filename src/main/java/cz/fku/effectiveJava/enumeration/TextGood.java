package cz.fku.effectiveJava.enumeration;

import java.util.Set;

public class TextGood {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }
}
