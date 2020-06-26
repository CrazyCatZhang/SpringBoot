package com.catzhang.restfulcrud.controller;

import com.catzhang.restfulcrud.pojo.Department;
import com.catzhang.restfulcrud.pojo.Employee;
import com.catzhang.restfulcrud.service.DepartmentService;
import com.catzhang.restfulcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/emps")
    public String list(Model model){
        final List<Employee> employeeList = employeeService.find();
        model.addAttribute("emps",employeeList);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        final List<Department> departmentList = departmentService.find();
        model.addAttribute("depts",departmentList);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        System.out.println("增加的员工信息"+employee);
        employeeService.insertEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,
                             Model model){
        final Employee employeeByID = employeeService.getEmployeeByID(id);
        model.addAttribute("emp",employeeByID);
        final List<Department> departmentList = departmentService.find();
        model.addAttribute("depts",departmentList);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
//        System.out.println("修改的员工数据:"+employee);
        employeeService.saveEmployee(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/emps";
    }
}
