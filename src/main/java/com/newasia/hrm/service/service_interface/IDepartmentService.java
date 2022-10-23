package com.newasia.hrm.service.service_interface;

import com.newasia.hrm.model.Department;

import java.util.List;

public interface IDepartmentService {
    void saveDepartment(Department department);
    List<Department> findAllDepartment();
}
