package evg.testt.aop;

import evg.testt.aop.logger.LoggerProxy;
import evg.testt.aop.pointcut.AspectDepartmentPointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by funtusthan on 12.02.16.
 */

@Aspect
public class AspectDepartmentController extends AspectDepartmentPointcut {

    LoggerProxy logger;

    @Before("add()")
    public void beforeAdd(JoinPoint joinPoint){
        logger.warn("before add new Department");
        System.out.println("before add new Department " + joinPoint.getSignature());
    }

    @AfterReturning("add()")
    public void afterReturningAdd(){
        logger.info("before add Department");
    }
    @Before("delete()")
    public void beforeDelete(){
        logger.warn("before delete new Department");
    }

    @AfterReturning("delete()")
    public void afterReturningDelete(){
        logger.info("before delete Department");
    }
    @Before("update()")
    public void beforeUpdate(){
        logger.warn("before update new Department");
    }

    @AfterReturning("update()")
    public void afterReturningUpdate(){
        logger.info("before update Department");
    }

    @AfterThrowing(pointcut = "add()", throwing = "ex")
    public void afterAddThrowing(Exception ex){
        logger.error("Exception add " + ex);
    }

    @AfterThrowing(pointcut = "delete()", throwing = "ex")
    public void afterDeleteThrowing(Exception ex){
        logger.error("Exception add " + ex);
    }

    @AfterThrowing(pointcut = "update()", throwing = "ex")
    public void afterUpdateThrowing(Exception ex){
        logger.error("Exception add " + ex);
    }
}
