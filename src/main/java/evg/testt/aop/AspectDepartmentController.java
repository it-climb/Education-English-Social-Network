package evg.testt.aop;

import evg.testt.aop.logger.LoggerProxy;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by funtusthan on 12.02.16.
 */

@Aspect
public class AspectDepartmentController extends AspectDepartmentPointcut {

    LoggerProxy loggerProxy;

    @Before("add()")
    public void beforeAdd(){
        loggerProxy.warn("before add new Department");
    }

    @AfterReturning("add()")
    public void afterReturningAdd(){
        loggerProxy.info("before add Department");
    }
    @Before("delete()")
    public void beforeDelete(){
        loggerProxy.warn("before delete new Department");
    }

    @AfterReturning("delete()")
    public void afterReturningDelete(){
        loggerProxy.info("before delete Department");
    }
    @Before("update()")
    public void beforeUpdate(){
        loggerProxy.warn("before update new Department");
    }

    @AfterReturning("update()")
    public void afterReturningUpdate(){
        loggerProxy.info("before update Department");
    }
}
