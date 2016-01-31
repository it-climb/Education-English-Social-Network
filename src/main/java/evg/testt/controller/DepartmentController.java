package evg.testt.controller;

import evg.testt.model.Chat;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController{

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ChatService chatService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        List<Chat> chat = chatService.getAll();
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ALL);
        modelAndView.addObject("email", sessionUser.getEmail());
        modelAndView.addObject("chat", chat);
        modelAndView.addObject("departments", departmentService.getAll());
        return modelAndView;
    }

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

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        departmentService.delete(Department.newBuilder().setId(id).build());
        return "redirect:/dep";
    }

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
