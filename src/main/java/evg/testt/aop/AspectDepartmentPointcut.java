package evg.testt.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by funtusthan on 12.02.16.
 */
public class AspectDepartmentPointcut {

    @Pointcut("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void add(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void delete(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void update(){}
}
