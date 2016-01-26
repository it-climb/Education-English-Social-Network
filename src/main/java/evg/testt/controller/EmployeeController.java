package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL);
        Department department = departmentService.getById(id);
        modelAndView.addObject("department", department);
        modelAndView.addObject("employees", employeeService.getByDepartment(department));
        return modelAndView;
    }

    @RequestMapping(value = "/employeeSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Employee employee, @RequestParam(required = true) Integer departmentId) throws SQLException {
        Department department = departmentService.getById(departmentId);
        employee.setDepartment(department);
        if(employee.getId()==null){
            employeeService.insert(employee);
        }else{
            employeeService.update(employee);
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/employeeEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer department_id, @RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_EDIT);
        Employee employee;
        if(id!=null) {
            employee = employeeService.getById(id);
        }else{
            Department department = departmentService.getById(department_id);
            employee = Employee.newBuilder().setDepartment(department).build();
        }
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/employeeDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = employeeService.getById(id);
        employeeService.delete(employee);
        return "redirect:/dep";
    }

}
