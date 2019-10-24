package cz.fku.geecon_epam;

/**
 * Hello world!
 *
 */
public class Epam
{
    public static void main( String[] args ) {
        foo(null);
    }

    public static void foo(String o) {
        System.out.println("string impl");
    }

    public static void foo(Object o) {
        System.out.println("object impl");
    }
}
