package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.User;
import evg.testt.service.ChatService;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.LockModeType;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class DepartmentController{

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ChatService chatService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser == null){
            ModelAndView modelAndView = new ModelAndView(JspPath.ISE_ERROR_VIEW);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ALL);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("departments", departmentService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer id, @RequestParam(required = true) String name,
                            @RequestParam(required = false) Long version, HttpServletRequest request) throws SQLException {
        Department department = Department.newBuilder().setName(name).setId(id).setVersion(version).build();

        if (id == null) {
            departmentService.insert(department);

        } else {

            try {
                departmentService.update(department);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/except";
            }
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne (@RequestParam(required = true) Integer id)throws SQLException {
            String direct = "";
            Department department; //= Department.newBuilder().setId(id).build();
            department = departmentService.getById(id);
            if (department.getEmployees().size() == 0) {
                departmentService.delete(department);
                direct = "redirect:/dep";
            } else {
                direct = "redirect:/employees?id=" + department.getId() + "&toDel=yes";
            }

            return direct;
        }

    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView updateOne (@RequestParam(required = false) Integer id)throws SQLException {
            ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_EDIT);
            if (id != null) {
                Department department = departmentService.getById(id);
                modelAndView.addObject("department", department);
            }
            return modelAndView;
        }
    }
