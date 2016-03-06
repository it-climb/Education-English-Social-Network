package evg.testt.controller;

import evg.testt.model.KnowledgeLevelUnits;
import evg.testt.model.Subject;
import evg.testt.model.User;
import evg.testt.model.UserData;
import evg.testt.service.KnowledgeLevelPointsService;
import evg.testt.service.KnowledgeLevelUnitsService;
import evg.testt.service.SubjectService;
import evg.testt.service.UserDataService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class KnowledgeLevelUnitsController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private KnowledgeLevelUnitsService knowledgeLevelUnitsService;



    @RequestMapping(value = "/units")
    public ModelAndView showUnits(HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.UNITS_ALL);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserData userData = userDataService.findByUser(user);

        Set< KnowledgeLevelUnits > knowledgeLevelUnitsSet = new HashSet<>();
        KnowledgeLevelUnits knowledgeLevelUnits_1 = new KnowledgeLevelUnits();
        knowledgeLevelUnits_1.setLevelUnits(15);
        Subject subject1 = new Subject();
        subject1.setName("Biology");
        knowledgeLevelUnits_1.setSubject(subjectService.insert(subject1));
        knowledgeLevelUnits_1 = knowledgeLevelUnitsService.insert(knowledgeLevelUnits_1);

        KnowledgeLevelUnits knowledgeLevelUnits_2 = new KnowledgeLevelUnits();
        knowledgeLevelUnits_2.setLevelUnits(30);
        /*Subject subject2 = new Subject();
        subject2.setName("Biology");*/
        knowledgeLevelUnits_2.setSubject(subjectService.insert(subject1));
        knowledgeLevelUnits_2 = knowledgeLevelUnitsService.insert(knowledgeLevelUnits_2);

        knowledgeLevelUnitsSet.add(knowledgeLevelUnits_1);
        knowledgeLevelUnitsSet.add(knowledgeLevelUnits_2);

        userDataService.addKnowledgeLevelUnits(userData, knowledgeLevelUnitsSet);

        List<KnowledgeLevelUnits> unitsList = userDataService.getUnitsPerSubject(userData);
        modelAndView.addObject("email", user.getEmail());
        modelAndView.addObject("unitsList", unitsList);
        return modelAndView;
    }

}
