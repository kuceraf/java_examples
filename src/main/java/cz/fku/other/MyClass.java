package cz.fku.other;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MyClass {

    public static void main(String[] args) {
        printInnerClassConstructors(MyClass.class);
    }

    public static void printInnerClassConstructors(Class<?> myClass) {
        for (Class<?> c : myClass.getDeclaredClasses()) {
            System.out.printf("inner class: %s%n", c.getName());
            for (Constructor<?> constructor : c.getDeclaredConstructors()) {
                System.out.printf("Constructor: %s%n", constructor);
            }
            for (Field field : c.getDeclaredFields()) {
                System.out.printf("Field: %s%n", field);
            }
        }
    }

//    INNER CLASSES
    public class MyInnerClass {
//        Java automatically adds constructor parameter to inners enclosing class
//        constructor has really this signature:
//        cz.fku.other.MyClass$MyInnerClass(cz.fku.other.MyClass)
        MyInnerClass(){}
    }

    public class MyInnerClass2 {
        MyInnerClass2(String s){}
    }

    public static class MyInnerClass3 {
    }

    final public class MyInnerClass4 {
    }
}
