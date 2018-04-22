package cz.fku.designPatterns.visitor;

public class PostageVisitor implements Visitor {
    private double totalPostageForCart;
    @Override
    public void visit(Book book) {
        //assume we have a calculation here related to weight and price
        //free postage for a book over 10
        if(book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }

    @Override
    public void visit(DVD book) {
        // DVDs are shipped cheaply
        totalPostageForCart += book.getWeight() * 1.5;
    }

    public double getTotalPostageForCart() {
        return totalPostageForCart;
    }
}
