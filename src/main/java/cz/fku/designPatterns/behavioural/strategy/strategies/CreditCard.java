package cz.fku.designPatterns.behavioural.strategy.strategies;

public class CreditCard extends Card {

    public CreditCard(String nameOnCard, String number, String cvv, String expirationDate) {
        super(nameOnCard, number, cvv, expirationDate);
    }

    @Override
    protected String getType() {
        return "credit";
    }

    @Override
    protected void executeTransaction(double amount) {
        // TODO
    }
}
