package cz.fku.designPatterns.behavioural.visitor;

public class WeightVisitor implements Visitor {
    private double totalWeight;
    @Override
    public void visit(Book book) {
        totalWeight = totalWeight + book.getWeight();
    }

    @Override
    public void visit(DVD book) {
        totalWeight = totalWeight + book.getWeight();
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
