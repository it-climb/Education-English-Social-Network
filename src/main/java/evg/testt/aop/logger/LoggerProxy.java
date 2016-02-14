package evg.testt.aop.logger;

/**
 * Created by funtusthan on 12.02.16.
 */
public class LoggerProxy extends LoggerAdapter implements LoggerMathodWraper {

    @Override
    public void info(String message) {
        INFO_LOGGER.info(message);
    }

    @Override
    public void error(String message) {
        ERROR_LOGGER.error(message);
    }

    @Override
    public void warn(String message) {
        WARN_LOGGER.warn(message);
    }
}
