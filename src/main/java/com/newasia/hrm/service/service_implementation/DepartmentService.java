package com.newasia.hrm.service.service_implementation;

import com.newasia.hrm.model.Department;
import com.newasia.hrm.repository.DepartmentRepository;
import com.newasia.hrm.service.service_interface.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        return (List<Department>) departmentRepository.findAll();
    }
}
