package cz.fku.effectiveJava.exception;

public class HigherLevelClass {
    public class HigherLevelException extends Exception {
        public HigherLevelException(String message, Throwable cause){
            super(message, cause);
        }
    }

    private class LowerLevelException extends Exception {
        public LowerLevelException(String message){
            super(message);
        }
    }

    public void higherLevelMethod() throws HigherLevelException {
        try {
            lowerLevelMethod();
        } catch (LowerLevelException cause) {
            throw new HigherLevelException("Message from HigherLevelException", cause);
        }
    }

    private void lowerLevelMethod() throws LowerLevelException {
        throw new LowerLevelException("Message from LowerLevelException");
    }
}
