package evg.testt.aop.logger;

import org.apache.log4j.Logger;

/**
 * Created by funtusthan on 12.02.16.
 */
public class LoggerAdapter {

    protected static final Logger WARN_LOGGER = Logger.getLogger("warnLogger");
    protected static final Logger INFO_LOGGER = Logger.getLogger("infoLogger");
    protected static final Logger ERROR_LOGGER = Logger.getLogger("errorLogger");

    public static Logger getWarnLogger() {
        return WARN_LOGGER;
    }

    public static Logger getInfoLogger() {
        return INFO_LOGGER;
    }

    public static Logger getErrorLogger() {
        return ERROR_LOGGER;
    }
}
