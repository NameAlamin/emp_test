package com.newasia.hrm.controller;

import com.newasia.hrm.model.Department;
import com.newasia.hrm.service.service_implementation.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department_form")
    public String saveDepartment(Model model){
        Department department = new Department();
        model.addAttribute("department",department);
        return "department_form";
    }

    @PostMapping("/storeDepartment")
    public String storeDepartment(Model model, @ModelAttribute Department department){
        departmentService.saveDepartment(department);
        model.addAttribute("department",department);
        return "index";
    }

}
