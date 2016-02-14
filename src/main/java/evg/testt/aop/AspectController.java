package evg.testt.aop;

import evg.testt.aop.logger.LoggerProxy;
import evg.testt.aop.pointcut.AspectDepartmentPointcut;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 12.02.16.
 */

@Component
@Aspect

public class AspectController extends AspectDepartmentPointcut
        implements
        MethodBeforeAdvice,
        AfterReturningAdvice {

    protected static final Logger WARN_LOGGER = Logger.getLogger("warnLogger");
    protected static final Logger INFO_LOGGER = Logger.getLogger("infoLogger");
    protected static final Logger ERROR_LOGGER = Logger.getLogger("errorLogger");
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after " + method.toString());
        WARN_LOGGER.warn("after " + method.getName() + " " + o.toString() + " " + o1.toString());
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }

//    LoggerProxy logger;
//
//    @Before("add()")
//    public void beforeAdd(JoinPoint joinPoint){
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.toString());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getKind());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.toLongString());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getArgs());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getSignature());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getSignature().getDeclaringType());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint);
////        logger.warn("before add new Department " + joinPoint.toString());
//    }
//
//    @AfterReturning("add()")
//    public void afterReturningAdd(){
////        logger.info("before add Department");
//    }
//    @Before("delete()")
//    public void beforeDelete(){
////        logger.warn("before delete new Department");
//    }
//
//    @AfterReturning("delete()")
//    public void afterReturningDelete(){
////        logger.info("before delete Department");
//    }
//    @Before("update()")
//    public void beforeUpdate(){
////        logger.warn("before update new Department");
//    }
//
//    @AfterReturning("update()")
//    public void afterReturningUpdate(){
////        logger.info("before update Department");
//    }
//
//    @AfterThrowing(pointcut = "add()", throwing = "ex")
//    public void afterAddThrowing(Exception ex){
////        logger.error("Exception add " + ex);
//    }
//
//    @AfterThrowing(pointcut = "delete()", throwing = "ex")
//    public void afterDeleteThrowing(Exception ex){
////        logger.error("Exception add " + ex);
//    }
//
//    @AfterThrowing(pointcut = "update()", throwing = "ex")
//    public void afterUpdateThrowing(Exception ex){
////        logger.error("Exception add " + ex);
//    }
}
