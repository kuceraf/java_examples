package cz.fku.designPatterns.behavioural.strategy.strategies;

import cz.fku.designPatterns.behavioural.strategy.PaymentMethod;

public class Cash implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payed " + amount + " cents using cash");
    }
}
