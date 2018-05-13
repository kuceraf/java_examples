package cz.fku.designPatterns.behavioural.strategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentAppTest {

    @Test
    public void payBill_byCreditCard() {
        Bill bill = new Bill();
        bill.addLineItem(new LineItem("itme 1", 10));
        bill.addLineItem(new LineItem("itme 2", 20));

        PaymentApp.payBill(bill, "credit");
    }
}