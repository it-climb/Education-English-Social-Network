package evg.testt.controller;

import evg.testt.model.Subject;
import evg.testt.service.SubjectService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * Create page where you can see all yours available subjects or you can create a new one
     * @param edit
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public ModelAndView allSubject(@RequestParam(required = false) String edit) throws SQLException {
        ModelAndView modelAndView;
        if (edit != null) {
            modelAndView = new ModelAndView(JspPath.SUBJECT_EDIT);
        }
        else {
            modelAndView = new ModelAndView(JspPath.SUBJECT_ALL);
        }
        List<Subject> subjects = subjectService.getAll();
        modelAndView.addObject("subjects", subjects);
        return modelAndView;
    }

    /**
     * Update current subject
     * @return
     * @throws SQLException
     */

    @RequestMapping(value = "/subjectEdit", method = RequestMethod.GET)
    public String editSubject() throws SQLException {
        return "redirect:/subject?edit=true";
    }

    /**
     * Method used to delete the current subject
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/subjectDelete", method = RequestMethod.POST)
    public String deleteSubject (@RequestParam(required = true) String id) throws SQLException {
        subjectService.delete(subjectService.getById(Integer.parseInt(id)));
        return "redirect:/subject?edit=true";
    }

    /**
     *  page where you can update current subject (rename)
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/subjectUpdate", method = RequestMethod.POST)
    public ModelAndView updateSubject(String id) throws SQLException {
        return new ModelAndView(JspPath.SUBJECT_UPDATE, "subject", subjectService.getById(Integer.parseInt(id)));
    }

    /**
     * page where you can add new subject
     * @return
     */
    @RequestMapping(value = "/subjectAdd", method = RequestMethod.POST)
    public ModelAndView addSubject() {
        return new ModelAndView(JspPath.SUBJECT_UPDATE);
    }

    /**
     * Save new or updated subject in DB ;
     * @param id
     * @param name
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/subjectSave", method = RequestMethod.POST)
    public String saveSubject (@RequestParam(required = false) String id,
                               @RequestParam(required = true) String name) throws SQLException {
        if (id != "") {
            Subject subject = subjectService.getById(Integer.parseInt(id));
            subject.setName(name);
            subjectService.update(subject);
        }
        else {
            Subject subject = new Subject();
            subject.setName(name);
            subjectService.insert(subject);
        }
        return "redirect:/subject?edit=true";
    }

}
