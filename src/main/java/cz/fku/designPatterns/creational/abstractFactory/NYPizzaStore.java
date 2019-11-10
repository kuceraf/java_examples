package cz.fku.designPatterns.creational.abstractFactory;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {
        Pizza pizza;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        switch (item) {
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("NY style cheese pizza");
                break;
            case "clam":
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("NY style clam pizza");
            default:
                throw new IllegalStateException("Unexpected value: " + item);
        }

        return pizza;
    }
}
