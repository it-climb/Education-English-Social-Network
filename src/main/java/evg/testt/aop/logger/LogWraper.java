package evg.testt.aop.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by funtusthan on 08.02.16.
 */
public abstract class LogWraper {

    protected static final Logger INFO_LOGGER = LogManager.getLogger("infoLogger");
    protected static final Logger WARN_LOGGER = LogManager.getLogger("warnLogger");
    protected static final Logger ERROR_LOGGER = LogManager.getLogger("errorLogger");
    protected static final Logger DEBUG_LOGGER = LogManager.getLogger("debugLogger");
    protected static final Logger ROOT_LOGGER = LogManager.getRootLogger();
}
