package cz.fku.classes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class ClassExamples {
    public static void main( String[] args ) throws Exception {
        Class<?> stringClass = Class.forName("cz.fku.classes.TestClass");
        Annotation[] annotations = stringClass.getAnnotations();
        Constructor<?>[] constructors = stringClass.getConstructors();
//        constructors[0].ge
    }
}
