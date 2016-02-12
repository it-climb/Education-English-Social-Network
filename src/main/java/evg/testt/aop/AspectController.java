package evg.testt.aop;

import evg.testt.aop.logger.LoggerProxy;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by funtusthan on 12.02.16.
 */

@Aspect
public class AspectController{

    LoggerProxy loggerProxy;

    @Pointcut("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void add(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void delete(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void update(){}

    @Before("add()")
    public void beforeAdd(){
        System.out.println("before add");
        loggerProxy.warn("before add new Department");
    }

    @AfterReturning("add()")
    public void afterReturningAdd(){
        System.out.println("after add");
        loggerProxy.info("before add Department");
    }
    @Before("delete()")
    public void beforeDelete(){
        System.out.println("before delete");
        loggerProxy.warn("before delete new Department");
    }

    @AfterReturning("delete()")
    public void afterReturningDelete(){
        System.out.println("after delete");
        loggerProxy.info("before delete Department");
    }
    @Before("update()")
    public void beforeUpdate(){
        System.out.println("before update");
        loggerProxy.warn("before update new Department");
    }

    @AfterReturning("update()")
    public void afterReturningUpdate(){
        System.out.println("after update");
        loggerProxy.info("before update Department");
    }
}
