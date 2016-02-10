package evg.testt.aop.logger;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 08.02.16.
 */
public interface Log {

    void loggerWriter(String methodAspectName, Method methodController);
}
