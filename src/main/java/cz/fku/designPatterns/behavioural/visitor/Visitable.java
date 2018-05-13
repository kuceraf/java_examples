package cz.fku.designPatterns.behavioural.visitor;

public interface Visitable {
    void accept(Visitor visitor);
}
