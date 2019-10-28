package cz.fku.designPatterns.structural.decorator.example2.decorators;

import cz.fku.designPatterns.structural.decorator.example2.Beverage;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super("Milk", 10, beverage);
    }
}
