package com.employee.controller;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.service.DepartmentService;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/list-departments";
    }

    @GetMapping("/add-department")
    public String addEmployee(Model model) {
        model.addAttribute("department", new Department());
        return "departments/add-department";
    }

    @PostMapping("/save-department")
    public String saveDepartment(@ModelAttribute("department") @Valid  Department department, BindingResult rs) {
        if(rs.hasErrors()){
            return "departments/add-department";
        }

        departmentService.addDepartment(department);
        return "redirect:/departments";

    }
    @PostMapping("/update-department/{id}")
    public String updateDepartment(@PathVariable("id") int id, @ModelAttribute("department")@Valid Department department, BindingResult rs) {
        if(rs.hasErrors()) {
            return "departments/update-department";
        }
        department.setId(id);
        departmentService.updatDepartment(department);
        return "redirect:/departments";

    }

    @GetMapping("/get-department")
    public String getDepartment(@RequestParam("departmentId") int id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "departments/update-department";
    }
    @GetMapping("/delete-department")
    public String deleteDepartment(@RequestParam("departmentId") int id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }





















}
