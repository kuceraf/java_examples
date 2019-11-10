package cz.fku.designPatterns.creational.abstractFactory;

import cz.fku.designPatterns.creational.abstractFactory.ingredience.Calms;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Cheese;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Dough;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Sauce;
import cz.fku.effectiveJava.method.Overloading;

// ABSTRACT FACTORY pattern
// provides an interface for creating families of related or dependent objects
// without specifying their concrete classes.
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Calms createClams();
}
