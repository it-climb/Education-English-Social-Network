package evg.testt.util.userActions;

import evg.testt.model.User;
import evg.testt.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class UserActionAOP {

    @Autowired
    UserService userService;

    public String superMagic(HttpServletRequest request){
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser!=null){
            String userEmail = sessionUser.getEmail();
            User user = userService.getByEmail(userEmail);
            return "Id user:"+user.getId()+" User email: "+user.getEmail();
        }else return "Guest";
    }

    @Before("execution(* evg.testt.controller.UserController.show(..))")
    public void showDepartmentAction()
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

   /* @Around("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void magic(ProceedingJoinPoint joinPoint) {
        System.out.println("BEFORE!");
        try {
            //Object[] arr = joinPoint.getArgs();
           // System.out.println(superMagic((HttpServletRequest) arr[3]));
          Object v =   joinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("AFTER!");

    }*/
    @After("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void afterMagic(JoinPoint joinPoint){
        Object[]arr = joinPoint.getArgs();
        System.out.println(superMagic((HttpServletRequest) arr[3]));
    }
}
