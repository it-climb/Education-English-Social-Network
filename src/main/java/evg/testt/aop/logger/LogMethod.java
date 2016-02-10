package evg.testt.aop.logger;

/**
 * Created by funtusthan on 08.02.16.
 */
public interface LogMethod {

    void writeInfo(String message);
    void writeDebug(String message);
    void writeError(String message);
    void writeWarn(String message);
    void writeRootTrace(String message);
}
