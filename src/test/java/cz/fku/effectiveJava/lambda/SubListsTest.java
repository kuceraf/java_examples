package cz.fku.effectiveJava.lambda;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class SubListsTest {

    @Test
    public void of() {
        Stream<List<String>> listStream = SubLists.of(List.of("a", "b", "c", "d"));
        List<List<String>> sublists = listStream.collect(Collectors.toList());
        assertThat(sublists).hasSize(11);
    }
}