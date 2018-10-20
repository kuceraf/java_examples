package cz.fku.effectiveJava.generalProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlPrinting {
    private static String URL_ADDRES = "https://www.seznam.cz/";
    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(URL_ADDRES).openStream()) {
            in.transferTo(System.out);
        }
    }
}
