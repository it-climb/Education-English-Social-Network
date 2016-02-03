package evg.testt.aop.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by funtusthan on 03.02.16.
 */
public class LoggerController {

    private static final Logger LOGGER = LogManager.getRootLogger();

    public void deleteBeforeDepartment() {
        LOGGER.info("before delete");
    }

    public void deleteAfterDepartment() {
        LOGGER.info("after delete");
    }
}
