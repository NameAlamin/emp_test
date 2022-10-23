package com.newasia.hrm.service.service_implementation;

import com.newasia.hrm.dto.EmployeeDto;
import com.newasia.hrm.model.EmployeeInfo;
import com.newasia.hrm.repository.EmployeeRepository;
import com.newasia.hrm.service.service_interface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void saveEmployee(EmployeeInfo employeeInfo) {
        employeeRepository.save(employeeInfo);
    }

    @Override
    public List<EmployeeInfo> findAllEmployee() {
        return (List<EmployeeInfo>) employeeRepository.findAll();
    }
}
