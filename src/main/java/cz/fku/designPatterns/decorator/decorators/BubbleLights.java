package cz.fku.designPatterns.decorator.decorators;

import cz.fku.designPatterns.decorator.ChristmasTree;

public class BubbleLights extends TreeDecorator {
    public BubbleLights(ChristmasTree christmasTree) {
        super(christmasTree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
