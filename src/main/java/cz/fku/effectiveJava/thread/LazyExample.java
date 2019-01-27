package cz.fku.effectiveJava.thread;

public class LazyExample {
    static String computeFieldValue() {
        return "A";
    }
    private static class FieldHolder {
        static final String fieldValue = computeFieldValue();
    }

    private static String getField() {
        return FieldHolder.fieldValue;
    }
}
