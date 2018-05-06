package cz.fku.designPatterns.decorator.decorators;

import cz.fku.designPatterns.decorator.ChristmasTree;

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
