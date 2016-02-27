package evg.testt.controller;

        import evg.testt.model.KnowledgeLevelPoints;
        import evg.testt.model.User;
        import evg.testt.model.UserData;
        import evg.testt.service.AuthorshipPointsService;
        import evg.testt.service.KnowledgeLevelPointsService;
        import evg.testt.service.UserDataService;
        import evg.testt.service.UserService;
        import evg.testt.util.JspPath;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;
        import java.sql.SQLException;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    KnowledgeLevelPointsService knowledgeLevelPointsService;

    @Autowired
    AuthorshipPointsService authorshipPointsService;


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.ACCOUNT_SHOW);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("user", sessionUser);
        modelAndView.addObject("authorshipPoints", authorshipPointsService.getByUser(sessionUser));
        modelAndView.addObject("knowledgeLevelPoints", knowledgeLevelPointsService.getListByUser(sessionUser));
        return modelAndView;
    }


    @RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
    public ModelAndView addNewOne(@RequestParam(required = true) String firstName,
                                  @RequestParam(required = true) String secondName,
                                  @RequestParam(required = true) String age,
                                  HttpServletRequest request)throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.ACCOUNT_SHOW);
        modelAndView.addObject("email", sessionUser.getEmail());
        User user = userService.getByEmail(sessionUser.getEmail());
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setAge(age);
        userService.update(user);
        modelAndView.addObject("userData", user);
        modelAndView.addObject("authorshipPoints", authorshipPointsService.getByUser(sessionUser));
        modelAndView.addObject("knowledgeLevelPoints", knowledgeLevelPointsService.getListByUser(sessionUser));
        return modelAndView;
    }
}