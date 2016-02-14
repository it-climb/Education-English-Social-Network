package evg.testt.aop;

import evg.testt.aop.logger.LoggerProxy;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 12.02.16.
 */

public class AspectController implements MethodBeforeAdvice, AfterReturningAdvice {

    LoggerProxy loggerProxy = new LoggerProxy();

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
        loggerProxy.loggerWriter("before", method.getName());

    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        for (Object o: args) {
            System.out.println(o.getClass().getName());
        }
        System.out.println("after " + method.getName() + " ... " + returnValue.getClass()
        + " ... " + args.getClass().getName() + " ... " + target.getClass().getName());
    }
}
