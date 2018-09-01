package cz.fku.effectiveJava.card;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void create1() {
        List<Card> cards = Deck.create1();
        assertThat(cards).hasSize(32);
    }

    @Test
    public void create2() {
        List<Card> cards = Deck.create2();
        assertThat(cards).hasSize(32);
    }
}