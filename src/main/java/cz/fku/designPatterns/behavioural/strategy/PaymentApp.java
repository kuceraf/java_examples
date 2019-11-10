package cz.fku.designPatterns.behavioural.strategy;


import cz.fku.designPatterns.creational.staticFactory.PaymentMethodFactory;

public class PaymentApp {
    public static void payBill(Bill bill, String paymentType) {
        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(paymentType); // strategy impl selection

        bill.pay(paymentMethod);
    }
}
