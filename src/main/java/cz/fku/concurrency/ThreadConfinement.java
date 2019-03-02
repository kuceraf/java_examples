package cz.fku.concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadConfinement {
    private static  ThreadLocal<String> connectionHolder = ThreadLocal.withInitial(() -> {return "aaa";});
    public static void main(String[] args) {
        connectionHolder.get();
    }
}
