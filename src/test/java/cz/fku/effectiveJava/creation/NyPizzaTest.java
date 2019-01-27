package cz.fku.effectiveJava.creation;

import org.junit.Test;

import static org.junit.Assert.*;

public class NyPizzaTest {
    @Test
    public void test() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.HAM)
                .build();
    }
}