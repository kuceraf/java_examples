package cz.fku.designPatterns.decorator;

public class Garland extends TreeDecorator {
    Garland(ChristmasTree christmasTree) {
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
