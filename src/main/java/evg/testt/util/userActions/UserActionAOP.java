package evg.testt.util.userActions;

import evg.testt.model.User;
import evg.testt.model.userActionModels.Actions;
import evg.testt.model.userActionModels.UserAction;
import evg.testt.service.UserActionService;
import evg.testt.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Aspect
@Component
public class UserActionAOP {

    @Autowired
    UserActionService userActionService;


    public void superMagic(HttpServletRequest request)throws Throwable{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser!=null){
            if(userActionService.get(Long.valueOf(sessionUser.getId().toString()))!=null){

            }else{
                Actions actions = new Actions();
                actions.setDescription("Зделаль что то!");
                actions.setTime(new Date());
                Actions actions1 = new Actions();
                actions1.setDescription("Зделаль то то!");
                actions1.setTime(new Date());

                List<Actions> actionsList = new ArrayList<>();
                actionsList.add(actions);
                actionsList.add(actions1);
                UserAction userAction = new UserAction();
                userAction.setId(Long.valueOf(sessionUser.getId().toString()));
                userAction.setActions(actionsList);
                userAction.setUserEmail(sessionUser.getEmail());
                userActionService.save(userAction);
            }

        }
    }

    @Before("execution(* evg.testt.controller.UserController.show(..))")
    public void showDepartmentAction()
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    /*@Around("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void magic(ProceedingJoinPoint joinPoint) {
        System.out.println("BEFORE!");
        try {

            joinPoint.proceed();
            System.out.println("AFTER!");
            Object[] arr = joinPoint.getArgs();
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(superMagic((HttpServletRequest) arr[3]));

        }catch (Throwable e){
            e.printStackTrace();
        }


    }*/
    @After("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void afterMagic(JoinPoint joinPoint)throws Throwable{
        Object[]arr = joinPoint.getArgs();
        superMagic((HttpServletRequest) arr[3]);
    }
}
