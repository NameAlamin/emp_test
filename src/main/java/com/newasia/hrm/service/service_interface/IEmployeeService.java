package com.newasia.hrm.service.service_interface;

import com.newasia.hrm.dto.EmployeeDto;
import com.newasia.hrm.model.EmployeeInfo;

import java.util.List;

public interface IEmployeeService {
    void saveEmployee(EmployeeInfo employeeInfo);
    List<EmployeeInfo> findAllEmployee();
}
