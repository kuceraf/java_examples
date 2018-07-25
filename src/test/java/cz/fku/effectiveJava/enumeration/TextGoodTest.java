package cz.fku.effectiveJava.enumeration;

import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.*;

public class TextGoodTest {

    @Test
    public void applyStyles() {
        TextGood textGood = new TextGood();
        textGood.applyStyles(EnumSet.of(TextGood.Style.BOLD, TextGood.Style.ITALIC));
    }
}