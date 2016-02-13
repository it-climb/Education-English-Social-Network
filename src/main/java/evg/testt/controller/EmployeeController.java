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
    public ModelAndView showAll(@RequestParam(required = true) Integer id,
                                @RequestParam(required = false) String toDel) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ALL);
        Department department = departmentService.getById(id);
        modelAndView.addObject("department", department);
        modelAndView.addObject("employees", employeeService.getByDepartment(department));
        String warning = "";
        if (toDel!=null && toDel.equals("yes")) {
            warning = "You can't delete department <b>"+department.getName()+"</b> becose it is not empty !<br>You must" +
                    " delete all emploees before!<br>";
        }
        modelAndView.addObject("warning", warning);
        return modelAndView;
    }

    @RequestMapping(value = "/employeeSaveOrUpdate", method = RequestMethod.POST)
    public String addNewOne(@ModelAttribute Employee employee, @RequestParam(required = true) Integer departmentId, @RequestParam(required = false) Long version  ) throws SQLException {
        Department department = departmentService.getById(departmentId);
        employee.setDepartment(department);
        employee.setVersion(version);
        if(employee.getId()==null){
            employeeService.insert(employee);
        }else{
            employeeService.update(employee);
        }
        return "redirect:/employees?id="+departmentId;
    }

    /**
     * Updates ore existing employee or creates the new one.
     *
     * @param department_id department id
     * @param id            employee id
     * @return              model and view
     * @throws              SQLException
     * @see                 Employee
     */
    @RequestMapping(value = "/employeeEdit", method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = false) Integer department_id, @RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_EDIT);
        Employee employee;
        if(id!=null) {
            employee = employeeService.getById(id);
        }else{
            employee = Employee.newBuilder().setDepartment(departmentService.getById(department_id)).build();
        }
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/employeeDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) Integer department_id) throws SQLException {
        employeeService.delete(Employee.newBuilder().setId(id).build());
        return "redirect:/employees?id="+department_id;
    }

}
