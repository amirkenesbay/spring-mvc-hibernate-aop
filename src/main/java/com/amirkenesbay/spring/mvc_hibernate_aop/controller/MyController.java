package com.amirkenesbay.spring.mvc_hibernate_aop.controller;

import com.amirkenesbay.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.amirkenesbay.spring.mvc_hibernate_aop.entity.Department;
import com.amirkenesbay.spring.mvc_hibernate_aop.entity.Employee;
import com.amirkenesbay.spring.mvc_hibernate_aop.service.DepartmentService;
import com.amirkenesbay.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/departments")
    public String showAllDepartments(Model model) {
        List<Department> allDepartments = departmentService.getAllDepartments();
        model.addAttribute("allDeps", allDepartments);
        return "all-departments";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/addNewDepartment")
    public String addNewDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "department-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "department-info";
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
