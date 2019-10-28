package cz.fku.designPatterns.structural.decorator.example2.decorators;

import cz.fku.designPatterns.structural.decorator.example2.Beverage;

public abstract class CondimentDecorator extends Beverage {
    private Beverage beverage;

    public CondimentDecorator(String description, double cost, Beverage beverage) {
        super(description, cost);
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +" & "+ super.getDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost() + super.getCost();
    }
}
