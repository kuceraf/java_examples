package cz.fku.effectiveJava.method;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Overloading {

    public static class Cheese {
        public Cheese(String name) {
            this.name = name;
        }
        String name;
    }
    public enum MyEnum {
        A,
        B,
        C;
    }

    public static void main(String[] args) {
//        EnumSet.of(MyEnum.A, MyEnum.B);
        getCheeses();
//        getCheeseOpt().filter()
    }

    private static Cheese[] getCheeses() {
        List<Cheese> cheeses = new ArrayList<>();
        Cheese cheeseA = new Cheese("a");
        cheeses.add(cheeseA);
        return cheeses.toArray(new Cheese[3]);
    }

    private static Optional<Cheese> getCheeseOpt() {
        return Optional.empty();
    }
}
