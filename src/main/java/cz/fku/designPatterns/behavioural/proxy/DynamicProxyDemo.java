package cz.fku.designPatterns.behavioural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Human {
    void walk();

    void talk();
}

class MyPerson implements Human {

    @Override
    public void walk() {
        System.out.println("I am walking");
    }

    @Override
    public void talk() {
        System.out.println("I am talking");
    }
}

class LoggingHandler implements InvocationHandler {

    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        calls.merge(name, 1, Integer::sum);

        if(name.contains("toString")) {
            return calls.toString();
        }
        return method.invoke(target, args);
    }

}


public class DynamicProxyDemo {
    // utility method to construct logging proxy with any object
    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{ itf },
                new LoggingHandler(target)
        );
    }

    public static void main(String[] args) {
        MyPerson person = new MyPerson();
        Human human = withLogging(person, Human.class);
        human.talk();
        human.talk();
        human.walk();
        System.out.println(human);
    }
}
