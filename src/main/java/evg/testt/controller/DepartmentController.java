package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class DepartmentController{

    @Autowired
    DepartmentService departmentService;

    private static final Logger DEBUG_LOGGER = LogManager.getLogger("debugLogger");
    private static final Logger INFO_LOGGER = LogManager.getLogger("infoLogger");
    private static final Logger WARN_LOGGER = LogManager.getLogger("warnLogger");
    private static final Logger ERROR_LOGGER = LogManager.getLogger("errorLogger");

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() throws SQLException {
        try {
            INFO_LOGGER.info("Welcome page Departments");
            return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departmentService.getAll());
        } catch (SQLException e) {
            ERROR_LOGGER.error("Home Department does not open\n" +
                    "exception type: ", e);
            throw e;
        }
    }

    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer id, @RequestParam(required = true) String name) {
        Department department = Department.newBuilder().setName(name).setId(id).build();
//        if(id==null){
            try {
                departmentService.insert(department);
                DEBUG_LOGGER.debug("add new one department: " + department.getName());
            } catch (SQLException e) {
                ERROR_LOGGER.error("failed to add a new Department\n" +
                        "exception type: ", e);
            }
//        }else{
//            try {
//                departmentService.update(department);
//                DEBUG_LOGGER.debug("update department of " + department.getName());
//            } catch (SQLException e) {
//                ERROR_LOGGER.error("failed to update the Department of " +
//                        department.getName() + "\n" +
//                        "exception type: ", e);
//            }
//        }
        WARN_LOGGER.warn("method addNewOne was used!");
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) {
        Department department = Department.newBuilder().setId(id).build();
        try {
            departmentService.delete(department);
            DEBUG_LOGGER.debug("delete department of");
        } catch (SQLException e) {
            ERROR_LOGGER.error("Remove Department failed " +
                    department.getName() + "\n" +
                    "exception type: ", e);
        }
        DEBUG_LOGGER.debug("delete one department");
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_EDIT);
        if(id!=null){
            Department department = null;
            try {
                department = departmentService.getById(id);
                modelAndView.addObject("department", department);
                DEBUG_LOGGER.debug("update department of " + department.getName());
            } catch (SQLException e) {
                ERROR_LOGGER.error("failed to update the Department of " +
                        department.getName() + "\n" +
                        "exception type: ", e);
            }

        }
        return modelAndView;
    }

}
