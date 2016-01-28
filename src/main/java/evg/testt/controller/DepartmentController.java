package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
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

    /**
     * Shows all departments
     *
     * @return              model and view
     * @throws              SQLException
     */
    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() throws SQLException {
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departmentService.getAll());
    }

    /**
     * Creates new department or updates selected department
     *
     * @param id            department id
     * @param name          department name
     * @return              show all departments after changes
     * @throws              SQLException
     */
    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer id, @RequestParam(required = true) String name) throws SQLException {
        Department department = Department.newBuilder().setName(name).setId(id).build();
        if(id==null){
            departmentService.insert(department);
        }else{
            departmentService.update(department);
        }
        return "redirect:/dep";
    }

    /**
     * Deletes a selected department
     *
     * @param id            department id
     * @return              show all departments after changes
     * @throws              SQLException
     */
    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        departmentService.delete(Department.newBuilder().setId(id).build());
        return "redirect:/dep";
    }

    /**
     * Calls addNewOne method and gives to it new department's name
     *
     * @param id            department id
     * @return              model amd view
     * @throws              SQLException
     * @see                 Department
     */
    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_EDIT);
        if(id!=null){
            Department department = departmentService.getById(id);
            modelAndView.addObject("department", department);
        }
        return modelAndView;
    }

}
