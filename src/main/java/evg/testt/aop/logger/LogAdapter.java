package evg.testt.aop.logger;

/**
 * Created by funtusthan on 08.02.16.
 */
public class LogAdapter
        extends LogWraper implements LogMethod
{

    @Override
    public void writeInfo(String message){
        INFO_LOGGER.info(message);
    }

    @Override
    public void writeDebug(String message) {
        DEBUG_LOGGER.debug(message);
    }

    @Override
    public void writeError(String message) {
        ERROR_LOGGER.error(message);
    }

    @Override
    public void writeWarn(String message) {
        WARN_LOGGER.warn(message);
    }
}
