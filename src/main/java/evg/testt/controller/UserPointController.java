package evg.testt.controller;

import evg.testt.model.User;
import evg.testt.model.AuthorshipPoints;
import evg.testt.service.AuthorshipPointsService;
import evg.testt.service.KnowledgeLevelPointsService;
import evg.testt.service.UserService;
import evg.testt.model.KnowledgeLevelPoints;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        modelAndView.addObject("knowledgeLevelPoints", knowledgeLevelPointsService.getListByUser(sessionUser));
        return modelAndView;
    }

    @RequestMapping(value = "/klPointsUp", method = RequestMethod.POST)
    public String klPointsUp(@RequestParam(required = true) String subject,
                            @RequestParam(required = true) Integer klPointsUp,
                            HttpServletRequest request) throws SQLException {

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        KnowledgeLevelPoints knowledgeLevelPoints = knowledgeLevelPointsService.findByUserAndSubject(sessionUser, subject);
        knowledgeLevelPoints.increaseKnowledgeLevel(klPointsUp);
        knowledgeLevelPointsService.update(knowledgeLevelPoints);
        return "redirect:/points";
    }

    @RequestMapping(value = "/asPointsUpAndDown", method = RequestMethod.POST)
    public String asPointsUpAndDown(@RequestParam(required = false) Integer asPointsUp,
                            @RequestParam(required = false) Integer asPointsDown,
                            HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        AuthorshipPoints authorshipPoints = authorshipPointsService.getByUser(sessionUser);
        if(asPointsDown != null){
            authorshipPoints.decreaseAuthorshipPoints(asPointsDown);
        }
        if(asPointsUp != null){
            authorshipPoints.increaseAuthorshipPoints(asPointsUp);
        }
        authorshipPointsService.update(authorshipPoints);
        return "redirect:/points";
    }

    @RequestMapping(value = "/addKLPoints", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String subject, HttpServletRequest request) throws SQLException {

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        KnowledgeLevelPoints knowledgeLevelPoints = new KnowledgeLevelPoints();
        knowledgeLevelPoints.setSubject(subject);
        knowledgeLevelPoints.setUser(sessionUser);
        knowledgeLevelPoints.setKnowledgeLevelPoints(0);
        knowledgeLevelPointsService.insert(knowledgeLevelPoints);
        return "redirect:/points";
    }

    @RequestMapping(value = "/getBySubject", method = RequestMethod.GET)
    public ModelAndView showBySubject(@RequestParam(required = true) String subject,
                                      HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.POINTS_ALL);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("authorshipPoints", authorshipPointsService.getByUser(sessionUser));
        modelAndView.addObject("knowledgeLevelPoints", knowledgeLevelPointsService.getListByUser(sessionUser));
        modelAndView.addObject("knowledgePointsBySubject", knowledgeLevelPointsService.findByUserAndSubject(sessionUser, subject));
        return modelAndView;
    }
}
