package evg.testt.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by funtusthan on 12.02.16.
 */
@Component
public class AspectDepartmentPointcut {

    @Pointcut("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void add(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.deleteOne(..))")
    public void delete(){}

    @Pointcut("execution(* evg.testt.controller.DepartmentController.updateOne(..))")
    public void update(){}
}
