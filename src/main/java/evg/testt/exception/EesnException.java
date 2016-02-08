package evg.testt.exception;

/**
 * Created by alex on 01.02.16.
 */
public class EesnException extends Exception {

    public EesnException() {
        super();
    }

    public EesnException(String message) {
        super(message);
    }

    public EesnException(String message, Throwable cause) {
        super(message, cause);
    }

    public EesnException(Throwable cause) {
        super(cause);
    }

    protected EesnException(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
