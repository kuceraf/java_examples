package cz.fku.effectiveJava.enumeration;

import org.junit.Test;

public class TextBadTest {

    @Test
    public void applyStyles() {
        TextBad text = new TextBad();
        text.applyStyles(TextBad.STYLE_BOLD | TextBad.STYLE_ITALIC);
    }
}