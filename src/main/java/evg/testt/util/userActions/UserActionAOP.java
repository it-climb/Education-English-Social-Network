package evg.testt.util.userActions;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActionAOP {

    @Before("execution(* evg.testt.controller.UserController.show(..))")
    public void showDepartmentAction(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
