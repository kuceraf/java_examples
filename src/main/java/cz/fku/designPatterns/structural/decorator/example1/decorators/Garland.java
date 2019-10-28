package cz.fku.designPatterns.structural.decorator.example1.decorators;

import cz.fku.designPatterns.structural.decorator.example1.ChristmasTree;

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
