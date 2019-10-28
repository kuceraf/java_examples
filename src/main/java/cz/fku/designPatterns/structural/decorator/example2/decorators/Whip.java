package cz.fku.designPatterns.structural.decorator.example2.decorators;

import cz.fku.designPatterns.structural.decorator.example2.Beverage;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super("Whipsss", 30, beverage);
    }
}
