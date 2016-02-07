package evg.testt.exception.translateexceptions;


public class EmptyFieldException extends TranslateServiceException {

    public EmptyFieldException() {
    }

    public EmptyFieldException(String message) {
        super(message);
    }

    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFieldException(Throwable cause) {
        super(cause);
    }

    public EmptyFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
