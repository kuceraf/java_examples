package cz.fku.designPatterns.structural.decorator.example1.decorators;

import cz.fku.designPatterns.structural.decorator.example1.ChristmasTree;

public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree christmasTree;

    TreeDecorator(ChristmasTree christmasTree) {
        this.christmasTree = christmasTree;
    }

    @Override
    public String decorate() {
        return christmasTree.decorate();
    }
}
