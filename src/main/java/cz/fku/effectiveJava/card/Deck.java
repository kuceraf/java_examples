package cz.fku.effectiveJava.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    // Iterative Cartesian product computation
    public static List<Card> create1() {
        List<Card> result = new ArrayList<>();

        for(Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    // Stream-based Cartesian product computation
    public static List<Card> create2() {
        return Stream.of(Suit.values())
                // The "clumps" of values returned by each call to the mapper function are not distinguished at all in the output stream, t
                // hus the output is said to have been "flattened."
                .flatMap((suit) ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank))
                ).collect(Collectors.toList());
    };
}
