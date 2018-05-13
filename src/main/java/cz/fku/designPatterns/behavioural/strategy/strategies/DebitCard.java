package cz.fku.designPatterns.behavioural.strategy.strategies;

public class DebitCard extends Card {
    public DebitCard(String nameOnCard, String number, String cvv, String expirationDate) {
        super(nameOnCard, number, cvv, expirationDate);
    }

    @Override
    protected String getType() {
        return "debit";
    }

    @Override
    protected void executeTransaction(double amount) {

    }
}
