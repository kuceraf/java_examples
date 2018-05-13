package cz.fku.designPatterns.structural.decorator.decorators;

import cz.fku.designPatterns.structural.decorator.ChristmasTree;

public class Garland extends TreeDecorator {
    public Garland(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    private String decorateWithGarland() {
        return " with Garland";
    }
}
