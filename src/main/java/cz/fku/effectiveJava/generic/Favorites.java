package cz.fku.effectiveJava.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Favorites is typesafe heterogeneous container
 */
public class Favorites {
//When a class literal is passed among methods to communicate
//both compile-time and runtime type information, it is called a type token

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, instance);
    };
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    };
}
