package evg.testt.util.userActions;

import evg.testt.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class UserActionAOP {
    public String superMagic(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser==null){
            return "Guest";
        }else {
            String userInfo = sessionUser.getEmail();
            return userInfo;
        }
    }

   /* @Before("execution(* evg.testt.controller.UserController.show(..))")
    public void showDepartmentAction()
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }*/

    @Around("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void magic(ProceedingJoinPoint joinPoint) throws Throwable{
       Object[] arr = joinPoint.getArgs();
        System.out.println(superMagic((HttpServletRequest) arr[2]));
        joinPoint.proceed();
    }
}
