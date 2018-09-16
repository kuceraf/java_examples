package cz.fku.effectiveJava.method;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DefensiveCopyTest {

    @Test
    public void insertToMap() {
        DefensiveCopy defensiveCopy = new DefensiveCopy();
        DefensiveCopy.MutableKey mutableKey = new DefensiveCopy.MutableKey("a", "b");
        defensiveCopy.insertToMap(mutableKey, "ab");

        String result1 = defensiveCopy.searchMap(defensiveCopy.getLastKey());
        assertThat(result1).isEqualTo("ab");

        mutableKey.setVal1("c");

        String result2 = defensiveCopy.searchMap(defensiveCopy.getLastKey());
        assertThat(result2)
                .as("The key object has changed (its hashCode changed) and it can't be found in map anymore")
                .isNull();
    }
}