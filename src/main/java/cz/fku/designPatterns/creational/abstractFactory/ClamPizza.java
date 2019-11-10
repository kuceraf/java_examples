package cz.fku.designPatterns.creational.abstractFactory;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing pizza: " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        calms = ingredientFactory.createClams();
    }
}
