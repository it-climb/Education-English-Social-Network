package evg.testt.exception.translateexceptions;

import evg.testt.exception.EesnRuntimeException;

public class TranslateServiceException extends EesnRuntimeException {
    public TranslateServiceException() {
    }

    public TranslateServiceException(String message) {
        super(message);
    }

    public TranslateServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranslateServiceException(Throwable cause) {
        super(cause);
    }

    public TranslateServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
