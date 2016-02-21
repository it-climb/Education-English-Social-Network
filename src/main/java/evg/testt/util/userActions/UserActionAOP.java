package evg.testt.util.userActions;

import evg.testt.model.User;
import evg.testt.model.userActionModels.Action;
import evg.testt.model.userActionModels.UserAction;
import evg.testt.service.UserActionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Aspect
@Component
public class UserActionAOP {

    @Autowired
    UserActionService userActionService;


    public void actionLog(HttpServletRequest request, String event)throws Throwable{
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        Action action = new Action();
        action.setDescription(event);
        action.setTime(new Date());

        if(userActionService.get(Long.valueOf(sessionUser.getId().toString()))!=null){
            userActionService.update(sessionUser.getEmail(), action);
        }else {
            UserAction userAction = new UserAction();
            userAction.setId(Long.valueOf(sessionUser.getId().toString()));
            userAction.setUserEmail(sessionUser.getEmail());
            userActionService.save(userAction);
            userActionService.update(sessionUser.getEmail(),action);
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
            System.out.println(actionLog((HttpServletRequest) arr[3]));

        }catch (Throwable e){
            e.printStackTrace();
        }

    }*/
    @After("execution(* evg.testt.controller.DepartmentController.addNewOne(..))")
    public void afterAddOrUpdateDep(JoinPoint joinPoint)throws Throwable{
        Object[]arr = joinPoint.getArgs();
        Integer id = (Integer) arr[0];
        if(id == null){
            actionLog((HttpServletRequest)arr[3], EventAction.ADD_DEP);
        }else actionLog((HttpServletRequest)arr[3],EventAction.UDPDATE_DEP);
        //actionLog((HttpServletRequest) arr[3]);
    }
}
