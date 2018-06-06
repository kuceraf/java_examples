package cz.fku.effectiveJava.generic;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class FavoritesTest {

    @Test
    public void favorite() {
        Favorites favorites = new Favorites();

        favorites.putFavorite(Integer.class, 123);
        favorites.putFavorite(String.class, "abc");
        favorites.putFavorite(Class.class, Favorites.class);

        Integer favoriteInt = favorites.getFavorite(Integer.class);
        String favoriteStr = favorites.getFavorite(String.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        System.out.printf("%s %d %s%n", favoriteStr, favoriteInt, favoriteClass.getName());

    }

}