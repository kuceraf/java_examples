package cz.fku.designPatterns.decorator.decorators;

import cz.fku.designPatterns.decorator.ChristmasTree;
import cz.fku.designPatterns.decorator.decorators.TreeDecorator;

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
