package evg.testt.aop.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by funtusthan on 03.02.16.
 */
@Aspect
public class LoggerController {

    private static final Logger LOGGER = LogManager.getRootLogger();

    @Before("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteBeforeDepartment() {
        LOGGER.info("before delete");
    }

    @After("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteAfterDepartment() {
        LOGGER.info("after delete");
    }
}
