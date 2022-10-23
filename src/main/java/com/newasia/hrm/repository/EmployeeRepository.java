package com.newasia.hrm.repository;

import com.newasia.hrm.model.EmployeeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeInfo,Long> {
}
