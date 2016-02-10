package evg.testt.aop.logger;

import java.lang.reflect.Method;

/**
 * Created by funtusthan on 08.02.16.
 */
public class LogController
        implements Log
{

    protected LogAdapter logAdapter;

    @Override
    public void loggerWriter(String methodAspectName, Method methodController) {

        switch (methodAspectName){

            case "deleteOne" : logAdapter.writeWarn("delete [method] : " + methodController.getName());
                break;
            case "addNewOne" : logAdapter.writeInfo("incert [method] : " + methodController.getName());
                break;
            case "updateOne" : logAdapter.writeInfo("update [method] : " + methodController.getName());
        }
    }
}
