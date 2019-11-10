package cz.fku.designPatterns.creational.abstractFactory;

import cz.fku.designPatterns.creational.abstractFactory.ingredience.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Calms createClams() {
        return new FreshCalms();
    }
}
