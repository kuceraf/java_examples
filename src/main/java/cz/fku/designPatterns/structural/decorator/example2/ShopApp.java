package cz.fku.designPatterns.structural.decorator.example2;

import cz.fku.designPatterns.structural.decorator.example2.decorators.Milk;
import cz.fku.designPatterns.structural.decorator.example2.decorators.Whip;

public class ShopApp {
    public static void main(String[] args) {
        Beverage beverage1 = new Milk(new DarkRoast());
        System.out.println(beverage1.getDescription() + " TOTAL: " + beverage1.getCost());

        Beverage beverage2 = new Milk(new Whip(new Decaf()));
        System.out.println(beverage2.getDescription() + " TOTAL: " + beverage2.getCost());
    }
}
