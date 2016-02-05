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
public class AspectLoggerController {

    private static final Logger LOGGER = LogManager.getRootLogger();

    @Before("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteBeforeDepartment() {
        LOGGER.info("before delete");
    }

    @After("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteAfterDepartment() {
        LOGGER.info("after delete");
    }

    @Before("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void updateBeforeDepartment() {
        LOGGER.info("before update");
    }

    @After("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void updateAfterDepartment() {
        LOGGER.info("after update");
    }

    @Before("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void addBeforeDepartment() {
        LOGGER.info("before added");
    }

    @After("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void addAfterDepartment() {
        LOGGER.info("after added");
    }
}
