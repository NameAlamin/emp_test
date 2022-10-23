package com.newasia.hrm.controller;

import com.newasia.hrm.model.EmployeeInfo;
import com.newasia.hrm.service.service_implementation.AddressService;
import com.newasia.hrm.service.service_implementation.DepartmentService;
import com.newasia.hrm.service.service_implementation.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

   private final DepartmentService departmentService;
   private final EmployeeService employeeService;
   private final AddressService addressService;

    public EmployeeController(DepartmentService departmentService,
                              EmployeeService employeeService,
                              AddressService addressService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
        this.addressService = addressService;
    }

    @GetMapping("/")
    public String showPage(Model model){
        return "index";
    }

    @GetMapping("/employee_form")
    public String showEmpForm(Model model){
        model.addAttribute("employeeInfo",new EmployeeInfo());
        model.addAttribute("departmentList",departmentService.findAllDepartment());
        model.addAttribute("addressList",addressService.findAllAddress());
        return "employee_form";
    }

    @PostMapping("/store_employee")
    public String storeEmployee(Model model, @ModelAttribute EmployeeInfo employeeInfo){
       employeeService.saveEmployee(employeeInfo);
       model.addAttribute("employeeInfo",employeeInfo);
       return "index";
    }

}