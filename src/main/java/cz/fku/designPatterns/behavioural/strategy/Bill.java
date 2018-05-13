package cz.fku.designPatterns.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<LineItem> lineItems = new ArrayList<>();
    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }
    public void removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
    }
    public double getTotalAmount() {
        return lineItems.stream().mapToDouble(item -> item.getAmount()).sum();
    }
    public void pay(PaymentMethod method) {
        method.pay(getTotalAmount());
    }
}
