package com.spring.jpa.dao;

import com.spring.jpa.dto.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
