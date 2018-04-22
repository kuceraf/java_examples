package cz.fku.designPatterns.visitor;

public interface Visitable {
    void accept(Visitor visitor);
}
