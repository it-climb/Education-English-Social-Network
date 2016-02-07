package evg.testt.aop.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 03.02.16.
 */
//@Aspect
public class AspectLoggerController implements MethodBeforeAdvice, AfterReturningAdvice {

//    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Logger INFO_LOGGER = LogManager.getLogger("infoLogger");
    private static final Logger WARN_LOGGER = LogManager.getLogger("warnLogger");
    private static final Logger ERROR_LOGGER = LogManager.getLogger("errorLogger");
    private static final Logger DEBUG_LOGGER = LogManager.getLogger("debugLogger");

//    @Before("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteBeforeDepartment() {
        WARN_LOGGER.warn("before delete");
    }

//    @After("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void deleteAfterDepartment() {
        INFO_LOGGER.info("after delete");
    }

//    @Before("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void updateBeforeDepartment() {
        WARN_LOGGER.warn("before update");
    }

//    @After("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void updateAfterDepartment() {
        INFO_LOGGER.info("after update");
    }

//    @Before("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void addBeforeDepartment() {
        WARN_LOGGER.warn("before added");
    }

//    @After("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void addAfterDepartment() {
        INFO_LOGGER.info("after added");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {

        if (method.getName().equals("addNewOne")){
            addAfterDepartment();}
        else if (method.getName().equals("deleteOne")){
            deleteAfterDepartment();}
        else if (method.getName().equals("updateOne")){
            updateAfterDepartment();}
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        if (method.getName().equals("addNewOne")){
            addBeforeDepartment();}
        else if (method.getName().equals("deleteOne")){
            deleteBeforeDepartment();}
        else if (method.getName().equals("updateOne")){
            updateBeforeDepartment();}
    }
}
