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

            case "before" : beforeMethod(methodController);
                break;
            case "afterReturning" : afterReturningMethod(methodController);
                break;
        }
    }

    private void beforeMethod(Method methodController){

        switch (methodController.getName()){

            case "deleteOne" : logAdapter.writeWarn("delete before [method] : " + methodController.getName());
                break;
            case "addNewOne" : logAdapter.writeWarn("incert before [method] : " + methodController.getName());
                break;
            case "updateOne" : logAdapter.writeWarn("update before [method] : " + methodController.getName());
        }
    }

    private void afterReturningMethod(Method methodController){

        switch (methodController.getName()){

            case "deleteOne" : logAdapter.writeWarn("delete after [method] : " + methodController.getName());
                break;
            case "addNewOne" : logAdapter.writeWarn("incert after [method] : " + methodController.getName());
                break;
            case "updateOne" : logAdapter.writeWarn("update after [method] : " + methodController.getName());
        }
    }
}

