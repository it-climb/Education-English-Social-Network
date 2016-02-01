package evg.testt.exception;

/**
 * Created by alex on 01.02.16.
 */
public class EesnRuntimeException extends RuntimeException{

    public EesnRuntimeException() {
        super();
    }

    public EesnRuntimeException(String message) {
        super(message);
    }

    public EesnRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EesnRuntimeException(Throwable cause) {
        super(cause);
    }

    protected EesnRuntimeException(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
