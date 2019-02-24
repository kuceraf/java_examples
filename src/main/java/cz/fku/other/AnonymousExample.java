package cz.fku.other;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class AnonymousExample {
    private Runnable instanceRunnable = new Runnable() {
        @Override
        public void run() { }
    };

    private static Runnable staticRunnable = new Runnable() {
        @Override
        public void run() { }
    };

    public static void main(String[] args) throws IllegalAccessException {
        // An inner class declared without a class name = anonymous class
        // creating an anonymous class - java append $number to the class name (anonymous class is different class than its enclosing class)
        Runnable localRunnable = new Runnable() {
            @Override
            public void run() { }
        };
        System.out.println("-- local anonymous class --");
        print(localRunnable.getClass(), localRunnable);
        /*
            -- local anonymous class --
            - constructors -
            cz.fku.other.AnonymousExample$3()
            - fields -
        */

        System.out.println("\n-- instance anonymous class --");
        AnonymousExample em = new AnonymousExample();
        print(em.instanceRunnable.getClass(), em.instanceRunnable);
        /*
            -- instance anonymous class --
            - constructors -
            cz.fku.other.AnonymousExample$1(cz.fku.other.AnonymousExample) -- em.instanceRunnable is inner anonymous class (in it's constructor is reference to is't enclosing class)

            - fields -
             field name: this$0, -- an implicit outer class instance field were added by the compiler
             field type: class cz.fku.other.AnonymousExample,
             field value: cz.fku.other.AnonymousExample@19469ea2
        */

        System.out.println("\n-- static member anonymous class --");
        print(staticRunnable.getClass(), staticRunnable);
    }

    public static void print(Class<?> c, Object instance) throws IllegalAccessException {
        System.out.println("- constructors -");
        for (Constructor<?> constructor : c.getDeclaredConstructors()) {
            System.out.println(constructor.toGenericString());
        }
        System.out.println("- fields -");
        for (Field field : c.getDeclaredFields()) {
            System.out.printf(" field name: %s,%n field type: %s,%n field value: %s%n",
                    field.getName(),
                    field.getType(),
                    field.get(instance));
        }
    }
}
