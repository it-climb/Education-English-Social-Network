package evg.testt.aop.logger;

import org.aopalliance.aop.Advice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 03.02.16.
 */
public class AspectLoggerController implements Advice, MethodBeforeAdvice,
        AfterReturningAdvice {

    LogController logController;

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        logController.loggerWriter("afterReturning", method);
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        logController.loggerWriter("before", method);
    }
}
