package cz.fku.designPatterns.creational.factory;

import cz.fku.designPatterns.behavioural.strategy.strategies.Cash;
import cz.fku.designPatterns.behavioural.strategy.strategies.CreditCard;
import cz.fku.designPatterns.behavioural.strategy.strategies.DebitCard;
import cz.fku.designPatterns.behavioural.strategy.PaymentMethod;

public class PaymentMethodFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type) {
            case "credit":
                return createCreditCard();
            case "debit":
                return createDebitCard();
            case "cash":
                return createCash();
        }
        throw new IllegalArgumentException();
    }
    private static CreditCard createCreditCard() {
        return new CreditCard("John Doe", "4111111111111111", "123", "01/22");
    }
    private static DebitCard createDebitCard() {
        return new DebitCard("John Doe", "4111111111111111", "123", "01/22");
    }
    private static Cash createCash() {
        return new Cash();
    }
}
