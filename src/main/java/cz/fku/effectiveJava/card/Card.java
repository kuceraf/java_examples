package cz.fku.effectiveJava.card;

public class Card {
    final Suit suit;
    final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}
