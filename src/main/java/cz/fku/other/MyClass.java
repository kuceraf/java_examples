package cz.fku.other;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//https://www.logicbig.com/tutorials/core-java-tutorial/java-language/implicit-outer-class-reference.html
public class MyClass {
    MyInnerClass2 instanceMyInnerClass2 = new MyInnerClass2("AAA");

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        printInnerClassConstructors(MyClass.class);

        MyClass myClass = new MyClass();
        // all instances of have reference filed (this$0) to it enclosing class (instance of MyClass)
        // an implicit outer class instance field were added by the compiler
        myClass.instanceMyInnerClass2.getClass().getDeclaredField("this$0").get(myClass.instanceMyInnerClass2);
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
        private String str;
        MyInnerClass2(String str){
            this.str = str;
        }
    }

    final public class MyInnerClass4 {
    }

//    STATIC NESTED CLASS
    public static class MyInnerClass3 {
    }

}
