package cz.fku.designPatterns.structural.decorator.decorators;


import cz.fku.designPatterns.structural.decorator.ChristmasTree;

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
