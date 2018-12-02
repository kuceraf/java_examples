package cz.fku.effectiveJava.exception;

public class ExceptionChaining {


    public static void main(String[] args) {
        HigherLevelClass higherLevelClass = new HigherLevelClass();
        try {
            higherLevelClass.higherLevelMethod();
        } catch (HigherLevelClass.HigherLevelException e) {
            throw new IllegalArgumentException("main method message", e);
        }
    }
}
