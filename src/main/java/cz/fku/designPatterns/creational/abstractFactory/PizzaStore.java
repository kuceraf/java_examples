package cz.fku.designPatterns.creational.abstractFactory;

public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();;
        pizza.cut();

        return pizza;
    }

    // this is the ABSTRACT FACTORY METHOD
    // defines an interface for creating an object, but lets subclasses decide which
    // class to instantiate. Factory Method lets a class defer instantiation to subclasses.
    abstract Pizza createPizza(String item);
}
