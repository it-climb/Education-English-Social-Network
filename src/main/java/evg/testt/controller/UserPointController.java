package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.AuthorshipPoints;
import evg.testt.service.AuthorshipPointsService;
import evg.testt.service.KnowledgeLevelPointsService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class UserPointController {

    @Autowired
    KnowledgeLevelPointsService knowledgeLevelPointsService;

    @Autowired
    AuthorshipPointsService authorshipPointsService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        // = userService.getByEmail(sessionUser.getEmail());
        ModelAndView modelAndView = new ModelAndView(JspPath.POINTS_ALL);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("authorshipPoints", authorshipPointsService.getByUser(sessionUser));
        modelAndView.addObject("knowledgeLevelPoints", knowledgeLevelPointsService.getByUser(sessionUser));
        return modelAndView;
    }

}
