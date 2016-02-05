package evg.testt.exception.translateexceptions;



public class TheSameLanguageException extends TranslateServiceException {

    public TheSameLanguageException() {
    }

    public TheSameLanguageException(String message) {
        super(message);
    }

    public TheSameLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public TheSameLanguageException(Throwable cause) {
        super(cause);
    }

    public TheSameLanguageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
