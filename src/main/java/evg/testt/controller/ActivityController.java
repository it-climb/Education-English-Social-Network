package evg.testt.controller;

import evg.testt.model.Subject;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.model.activities.Activity;
import evg.testt.model.activities.ActivityType;
import evg.testt.service.*;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    UserDataService userDataService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ActivityCommonService activityCommonService;


    /**
     * <p>It is used to display List of Activities with pagination and filtration by some parameters.<p/>
     * <p>PageRequest object need for obtain from database Activities only for required page.<p/>
     * <p>All request parameters is non required and will not be used or get the default values.<p/>
     * <p>Once defined parameters are stored from request to request by passing through the JSP<p/>
     * <p>until they changed.<p/>
     * @param request - HttpServletRequest, need for get user from session.
     * @param number - Integer number of Activities on page.
     * @param page -Integer number of required page
     * @param author - String email, need for request Activity list by User.
     * @return ModelAndView with String user email, List of Activities, PageRequest "paginator" object and
     * String author email if last was transferred.
     * @throws SQLException
     */
    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public ModelAndView showActivities(HttpServletRequest request,
                                       @RequestParam(required = false) Integer number,
                                       @RequestParam(required = false) Integer page,
                                       @RequestParam(required = false) String author,
                                       @RequestParam(required = false) String subject,
                                       @RequestParam(required = false) boolean onlyMy) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            return new ModelAndView(JspPath.ISE_ERROR_VIEW);
        }
        if (number == null) {
            number = 10;
        }
        if (page == null) {
            page = 0;
        }
        Pageable paginator = new PageRequest(page, number);
        ModelAndView modelAndView = new ModelAndView(JspPath.ACTIVITIES_SHOW);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("paginator", paginator);
        modelAndView.addObject("sub", subjectService.getAll());

        if (subject != null){

            List<Activity> acts = activityService.getAll();
            List<Subject> sub = subjectService.getAll();
            List<Integer> findActivityID = new ArrayList<>();
            List<Activity> findActivity = new ArrayList<>();

            for (Subject sub1 : sub) {
                if (sub1.getName().equals(subject)) {
                    findActivityID.add(sub1.getActivity().getId());
                }
            }
            for (Integer integer : findActivityID) {

                for (Activity act : acts) {
                    if (act.getId().equals(integer)) {
                        findActivity.add(act);
                    }
                }
            }
//            UserData userData = userDataService.findByUser(sessionUser);
            return modelAndView.addObject("activities", findActivity);
        }


        if(onlyMy){
            UserData userData = userDataService.findByUser(sessionUser);
            return modelAndView.addObject("activities", activityService.getByAuthor(userData));
        }
        if (author == null || author.isEmpty()) {
            return modelAndView.addObject("activities", activityService.getAll(paginator).getContent());
        }
        User user = userService.getByEmail(author);
        UserData userData = userDataService.findByUser(user);
        return modelAndView.addObject("activities", activityService.getByAuthor(userData));
//        UserData authorUserData = userDataService.findByUser(userService.getByEmail(author));
//        modelAndView.addObject("author", author);
//        return modelAndView.addObject("activities", activityCommonService.getActivityByAuthor(authorUserData,
//                paginator));
    }

    @RequestMapping(value = "/createActivities", method = RequestMethod.POST)
    public ModelAndView addActivities(@RequestParam(required = true) String num) {
        if (num.equals("watch")){
            return new ModelAndView(JspPath.WATCHING_ACTIVITY_ADD);
        }
        if (num.equals("read")){
            return new ModelAndView(JspPath.READING_ACTIVITY_ADD);
        }
        return new ModelAndView(JspPath.HOME);
    }

//    @RequestMapping(value = "/yoursActivities", method = RequestMethod.GET)
//    public ModelAndView showYoursActivities(@RequestParam(required = true) String num) {
//        if (num.equals("watch")){
//            return new ModelAndView(JspPath.WATCHING_ACTIVITY_ADD);
//        }
//        if (num.equals("read")){
//            return new ModelAndView(JspPath.READING_ACTIVITY_ADD);
//        }
//        return new ModelAndView(JspPath.HOME);
//    }
//    yoursActivities

}
