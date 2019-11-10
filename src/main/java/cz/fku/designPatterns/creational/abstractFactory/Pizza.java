package cz.fku.designPatterns.creational.abstractFactory;

import cz.fku.designPatterns.creational.abstractFactory.ingredience.Calms;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Cheese;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Dough;
import cz.fku.designPatterns.creational.abstractFactory.ingredience.Sauce;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Calms calms;

    abstract void prepare();

    void bake() {
        System.out.println("Baking the pizza for 25 minutes");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }


    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
}
