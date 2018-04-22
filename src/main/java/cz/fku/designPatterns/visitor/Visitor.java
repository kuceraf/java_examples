package cz.fku.designPatterns.visitor;

public interface Visitor {
    void visit(Book book);
    void visit(DVD book);
}
