package cz.fku.designPatterns.structural.decorator.example2;

public abstract class Beverage {
    private String description;
    private double cost;

    public Beverage(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public  String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
}
