package cz.fku.designPatterns.behavioural.visitor;

public interface Visitor {
    void visit(Book book);
    void visit(DVD book);
}
