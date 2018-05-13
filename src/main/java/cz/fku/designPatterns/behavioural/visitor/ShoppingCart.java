package cz.fku.designPatterns.behavioural.visitor;

import java.util.List;

public class ShoppingCart {
    public static void main( String[] args ) {
        List<Visitable> items = List.of(
                new Book(100, 12),
                new Book(120, 15),
                new DVD(200, 8));
        calculatePostage(items);
    }


    private static double calculateWeight(List<Visitable> items) {
        WeightVisitor weightVisitor = new WeightVisitor();
        items.forEach(visitable -> visitable.accept(weightVisitor));
        return weightVisitor.getTotalWeight();
    }
    private static double calculatePostage(List<Visitable> items) {
        PostageVisitor postageVisitor = new PostageVisitor();
        //iterate through all items
        for(Visitable item: items) {
            item.accept(postageVisitor);
        }
        return postageVisitor.getTotalPostageForCart();
    }
}
