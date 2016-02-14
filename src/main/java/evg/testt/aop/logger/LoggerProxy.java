package evg.testt.aop.logger;

/**
 * Created by funtusthan on 12.02.16.
 */
public class LoggerProxy extends LoggerAdapter implements LoggerMathodWraper {

    @Override
    public void loggerWriter(String message, String methodName) {
        switch (methodName){
            case "addNewOne" : WARN_LOGGER.warn(message);
                break;
            case "updateOne" : WARN_LOGGER.warn(message);
                break;
            case "deleteOne" : WARN_LOGGER.warn(message);
                break;
        }
    }
}
