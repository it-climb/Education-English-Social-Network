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

    /**
     * <p>Displays page for view, setup and edit session User points - authorship and knowledge level</p>
     * @param request must be to get user from session
     * @return ModelAndView with user email for dislay on page, his authorshipPoints and list of knowledgeLevelPoints
     * @throws SQLException
     */
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

    /**
     * <p>it allows to increase knowledge level for session User on some subject</p>
     * @param subject - subject the level of knowledge on which is increasing
     * @param klPointsUp - increment of knowledge level
     * @param request must be to get user from session
     * @return redirect to page view method
     * @throws SQLException
     */
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

    /**
     * <p>it allows to increase or decrease authorship points level for session User on some subject</p>
     * <p>if asPointsUp parameter was passed, authorshipPoints increase on this level</p>
     * <p>if asPointsDown parameter was passed, authorshipPoints increase on this level</p>
     * <p>both parameters are non required and both can be used together, but it scopes seems have no sense</p>
     * @param asPointsUp  - increment of knowledge level, non required
     * @param asPointsDown - decrement of knowledge level, required
     * @param request must be to get user from session
     * @return redirect to page view method
     * @throws SQLException
     */
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

    /**
     * <p>it allows to create knowledge level for session User to given subject</p>
     * @param subject - temporarily String, must be replaced to type SubjectModel
     * @param request must be to get user from session
     * @return redirect to page view method
     * @throws SQLException
     */
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

    /**
     * <p>it allows to display knowledge level for session User to given subject</p>
     * @param subject - temporarily String, must be replaced to type SubjectModel
     * @param request redirect to page view method
     * @return ModelAndView witch different from showAll method returned by having selected by given subject knowledgePoints
     * @throws SQLException
     */
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
