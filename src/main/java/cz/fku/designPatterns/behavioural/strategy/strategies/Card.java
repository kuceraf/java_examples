package cz.fku.designPatterns.behavioural.strategy.strategies;

import cz.fku.designPatterns.behavioural.strategy.PaymentMethod;

import java.text.MessageFormat;

public abstract class Card implements PaymentMethod {
    private final String nameOnCard;
    private final String number;
    private final String cvv;
    private final String expirationDate;

    Card(String nameOnCard, String number, String cvv, String expirationDate) {
        this.nameOnCard = nameOnCard;
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payed " + amount + " cents using " + toString());
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} card[name = {1}, number = {2}, CVV = {3}, expiration = {4}]", getType(), nameOnCard, number, cvv, expirationDate);
    }

    protected abstract String getType();
    protected abstract void executeTransaction(double amount);
}
