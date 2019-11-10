package cz.fku.designPatterns.creational.abstractFactory;

import cz.fku.designPatterns.creational.abstractFactory.ingredience.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PulmTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Calms createClams() {
        return new FreshCalms();
    }
}
