package evg.testt.exception;



public class PassingTestException extends EesnRuntimeException {

    public PassingTestException() {
    }

    public PassingTestException(String message) {
        super(message);
    }

    public PassingTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassingTestException(Throwable cause) {
        super(cause);
    }

    public PassingTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
